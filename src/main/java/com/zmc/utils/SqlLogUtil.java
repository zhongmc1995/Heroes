package com.zmc.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用aop拦截日志输出
 * Created by zhongmc on 2017/4/5.
 */
@Aspect
@Component
public class SqlLogUtil {
    private Logger log = LoggerFactory.getLogger(SqlLogUtil.class);

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        log.info("doBefore....");
    }

    @After("pointcut()")
    public void doAfter(){
        log.info("doAfter....");
    }

    @AfterReturning(returning = "result",pointcut = "pointcut()")
    public void doAfterReturning(Object result){
        log.info("result:{}",result);
    }
}
