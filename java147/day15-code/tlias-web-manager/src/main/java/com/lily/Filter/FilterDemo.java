package com.lily.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")//表示拦截所有请求
public class FilterDemo implements Filter {
    @Override
    //初始化方法，在web服务器启动时触发一次
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("FilterDemo init----------");
    }

    //每次拦截到请求就会触发该方法，会调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("FilterDemo doFilter-----------");
        filterChain.doFilter(servletRequest,servletResponse);//放行
    }
    //销毁方法，在web服务器正常关闭时触发一次
    @Override
    public void destroy() {
        log.info("FilterDemo destroy----------");
    }
}
