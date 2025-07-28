package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Slf4j

//@Aspect//声明切面类
//@Component
public class RecordTimeAspect {
    //通知
    @Around("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))") //.*连接点，即可以被调用的方法
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("执行时间：{}", end - start);
        return result;
    }
}
