package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
//@Component
public class Aspect2 {

    //@Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.list(..)) || execution(* com.itheima.service.impl.DeptServiceImpl.getById(..))")
    @Pointcut("@annotation(com.itheima.annotation.Log)")
    public void pt(){}
    @Before("pt()")
    public void before() {
        log.info("前置前通知.......");
    }
    @After("pt()")
    public void after() {
        log.info("前置后通知");
    }


}
