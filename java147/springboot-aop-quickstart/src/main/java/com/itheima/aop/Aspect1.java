package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
//@Component
public class Aspect1 {

    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}
    @Around("pt()")
    public Object myAspect1(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("环绕前通知....");
        Object result = joinPoint.proceed();
        log.info("环绕后通知.....");
        return result;
    }
    @Before("pt()")
    public void before() {
        log.info("前置前通知.......");
    }
    @After("pt()")
    public void after() {
        log.info("前置后通知");
    }
    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("返回后通知.......");
    }
    @AfterThrowing("pt()")
    public void afterThrowing() {
        log.info("异常后通知.....");
    }

}
