package com.jyd.config.xss;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="myXssFilter", urlPatterns="/*")
@Slf4j
public class MyXssFilter implements Filter {

    FilterConfig filterConfig = null;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //log.info("正在执行过滤操作");
        filterChain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest)servletRequest), servletResponse);
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁");
        this.filterConfig = null;
    }

}
