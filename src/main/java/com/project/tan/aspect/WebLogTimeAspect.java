package com.project.tan.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 记录请求的处理时间切面
 *
 * @Pointcut定义的切入点为com.didispace.web包下的所有函数（对web层所有请求处理做切入点）
 * @Author zhengqiang.tan
 * @Date 2020/9/16 8:12 PM
 * @Version 1.0
 */
@Aspect
@Component
@Order(2)
@Slf4j
public class WebLogTimeAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.project.tan.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : {}", ret.toString());
        log.info("COST TIME : {}", (System.currentTimeMillis() - startTime.get()));
    }

}
