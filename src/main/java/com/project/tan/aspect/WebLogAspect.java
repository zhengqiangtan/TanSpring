package com.project.tan.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 记录请求的切面
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/16 8:49 PM
 * @Version 1.0
 */
@Aspect
@Order(1)
@Component
@Slf4j
public class WebLogAspect {


    @Pointcut("execution(public * com.project.tan.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret.toString());
    }

}



//  2020-09-16 20:59:33.434 TRACE 66885 --- [nio-8080-exec-3] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to com.project.tan.controller.TestController#hello(String)
//  2020-09-16 20:59:33.437  INFO 66885 --- [nio-8080-exec-3] com.project.tan.aspect.WebLogAspect      : URL : http://localhost:8080/hi
//  2020-09-16 20:59:33.437  INFO 66885 --- [nio-8080-exec-3] com.project.tan.aspect.WebLogAspect      : HTTP_METHOD : GET
//  2020-09-16 20:59:33.437  INFO 66885 --- [nio-8080-exec-3] com.project.tan.aspect.WebLogAspect      : IP : 0:0:0:0:0:0:0:1
//  2020-09-16 20:59:33.437  INFO 66885 --- [nio-8080-exec-3] com.project.tan.aspect.WebLogAspect      : CLASS_METHOD : com.project.tan.controller.TestController.hello
//  2020-09-16 20:59:33.437  INFO 66885 --- [nio-8080-exec-3] com.project.tan.aspect.WebLogAspect      : ARGS : [World]
//  2020-09-16 20:59:33.441  INFO 66885 --- [nio-8080-exec-3] com.project.tan.aspect.WebLogTimeAspect  : RESPONSE : Hello World!
//  2020-09-16 20:59:33.442  INFO 66885 --- [nio-8080-exec-3] com.project.tan.aspect.WebLogTimeAspect  : COST TIME : 4
//  2020-09-16 20:59:33.442  INFO 66885 --- [nio-8080-exec-3] com.project.tan.aspect.WebLogAspect      : RESPONSE : Hello World!