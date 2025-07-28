package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class Aspect3 {

    //@Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.list(..)) || execution(* com.itheima.service.impl.DeptServiceImpl.getById(..))")
    @Pointcut("@annotation(com.itheima.annotation.Log)")
    public void pt(){}
    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        //获取类名
        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("className = " + className);
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("signature = " + signature);
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName = " + methodName);
        //获取方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("args = " + Arrays.toString(args));

    }
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();
        System.out.println("result = " + result);
        return result;
    }


}
