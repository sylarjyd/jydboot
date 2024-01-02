package com.jyd.config.security;

import com.alibaba.fastjson.JSON;
import com.jyd.vo.R;
import com.jyd.vo.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.PrintWriter;

@Configuration //注册为SpringBoot的配置类
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //配置SpringSecurity的身份预认证功能
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //注入Jwt认证拦截器.
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private LoginConfig loginConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] skipurl = loginConfig.getSkipurl().toArray(new String[loginConfig.getSkipurl().size()]);
        http.csrf().disable() //跨站请求伪造
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //由于我们使用token作为信息传递介质, 所以禁用Session
            .and()
            .authorizeRequests() // 进行认证请求的配置
            .antMatchers(skipurl).anonymous() // 将所有登入和注册的接口放开, 这些都是无需认证就访问的
            .anyRequest().authenticated() //除了上面的那些, 剩下的任何接口请求都需要经过认证
            .and()
            .cors(); //允许跨域请求

        //把token校验过滤器添加到过滤器链中, 添加在UsernamePasswordAuthenticationFilter之前是因为只要用户携带token, 就不需要再去验证是否有用户名密码了 (而且我们不使用表单登入, UsernamePasswordAuthenticationFilter是无法解析Json的, 相当于它没用了)
        //UsernamePasswordAuthenticationFilter是SpringSecurity默认配置的表单登录拦截器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 下面这个是权限拒绝处理器, 这个直接照搬就行了.
        http.exceptionHandling(it -> it.authenticationEntryPoint(((httpServletRequest, httpServletResponse, e) -> {
            R<?> failMsg = R.fail(ResultCode.UN_AUTHORIZED.getCode(), ResultCode.UN_AUTHORIZED.getMessage());
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(JSON.toJSONString(failMsg));
            writer.flush();
            writer.close();
        })));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // 身份验证管理器, 直接继承即可.
        return super.authenticationManagerBean();
    }

    // 将BCryptPasswordEncoder加密器注入SpringSecurity中, 之后SpringSecurity的DaoAuthenticaionProvider会调用该加密器中的match()方法进行密码比对, 密码比对过程不需要我们干涉
    @Bean
    public BCryptPasswordEncoder bcryptPasswordBean() {
        return new BCryptPasswordEncoder();
    }
}
