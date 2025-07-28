package com.lily.Filter;

import com.lily.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")

public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //0.强转对象
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        //1.获取请求url
        StringBuffer url=request.getRequestURL();//全部路径
        String uri=request.getRequestURI();
        log.info("uri:{}",uri);
        //2.判断url中是否包含login，是，进行登录操作，放行
        if(uri.contains("login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;//放行了要结束，否则会继续获取令牌
        }
        //3.获取请求头中的令牌
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String token=request.getHeader("token");
        log.info("token:{}",token);
        //4.判断token是否存在，否，响应401
        if(token==null){
            log.error("令牌为空！");
            response.setStatus(401);
            return;
            //throw new RuntimeException("未登录！请先登录");
        }
        //5.解析token，解析失败，响应401
        try {
            Claims claims = JwtUtils.parseJWT(token);
            log.info("claims:{}",claims);
        } catch (Exception e) {
            log.error("解析失败：{}",e.getMessage());
            response.setStatus(401);
            return;
            //throw new RuntimeException(e);
        }

        //6.放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
