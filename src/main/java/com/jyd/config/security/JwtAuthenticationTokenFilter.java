package com.jyd.config.security;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.jyd.common.constant.CommonConstants;
import com.jyd.common.utils.JwtUtil;
import com.jyd.config.redis.RedisCache;
import com.jyd.entity.User;
import com.jyd.service.IUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private IUserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader(CommonConstants.AUTHORIZATION);
        if (StrUtil.isEmpty(token)) {
            //token为空的话, 就不管它, 让SpringSecurity中的其他过滤器处理请求
            //请求放行
            filterChain.doFilter(request, response);
            return;
        }
        //token不为空时, 解析token
        String userid;
        try {
            Claims claims = jwtUtil.parseJWT(token);
            //解析出userid
            userid = claims.get(CommonConstants.USER_ID, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //使用userid从Redis缓存中获取用户信息
        String redisKey = CommonConstants.LOGIN_USER_PREFIX + userid;
        User loginUser = redisCache.getCacheObject(redisKey);
        if (ObjectUtil.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }
        //将用户安全信息存入SecurityContextHolder, 在之后SpringSecurity的过滤器就不会拦截
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
    }
}
