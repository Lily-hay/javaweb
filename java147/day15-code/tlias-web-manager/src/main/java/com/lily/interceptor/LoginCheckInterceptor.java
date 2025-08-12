package com.lily.interceptor;

import com.lily.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求url
        String uri=request.getRequestURI();
        log.info("uri:{}",uri);
        //2.判断url中是否包含login，是，进行登录操作，放行
        if(uri.contains("login")){
            return true;//放行了要结束，否则会继续获取令牌
        }
        //3.获取请求头中的令牌
        String token=request.getHeader("token");
        log.info("token:{}",token);
        //4.判断token是否存在，否，响应401
        if(token==null){
            log.error("令牌为空！");
            response.setStatus(401);
            return false;
        }
        //5.解析token，解析失败，响应401
        try {
            Claims claims = JwtUtils.parseJWT(token);
            log.info("claims:{}",claims);
        } catch (Exception e) {
            log.error("解析失败：{}",e.getMessage());
            response.setStatus(401);
            return false;
        }
        //6.放行
        return true;
    }
}
