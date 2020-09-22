package com.project.tan.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/22 4:40 PM
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class ControllerLogConfig {


    @Pointcut("execution(public * com.project.tan.controller.UserController.*.*(..))")
    public void recordLog() {

    }

    @Around("recordLog()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getName();
        String classMethod = className + "." + methodName;
        Object[] args = proceedingJoinPoint.getArgs();
        boolean hasMultifile = false;
        for (Object arg : args) {
            if (arg instanceof MultipartFile) {
                hasMultifile = true;
                break;
            }
        }
        if (!hasMultifile) {
            log.info("===controller执行方法: {} ,入参为: {} ====", classMethod, JSON.toJSONString(proceedingJoinPoint.getArgs()));
        }
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        final String logMessage = StringUtils.leftPad(Long.toString(stopWatch.getTotalTimeMillis()), 5) + " ms ";
        log.info("the classMethod: {} cost time: {}", classMethod, logMessage);
        log.info("===controller执行方法: {} ,出参为: {} ====", classMethod, JSON.toJSONString(result));
        return result;
    }
}
