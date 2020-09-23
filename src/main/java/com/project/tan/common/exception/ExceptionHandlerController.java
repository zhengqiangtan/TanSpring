package com.project.tan.common.exception;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.project.tan.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局自定义异常
 * <p>
 * @ControllerAdvice 通过AOP的方式配合@ExceptionHandler()注解捕获在Controller层面发生的异常
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/23 9:58 AM
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {
//
//    private static JSONObject normalException;
//    static {
//        normalException = new JSONObject();
//        normalException.put("code", 1);
//        normalException.put("data", null);
//    }

    /**
     * 捕获全局异常,处理所有不可知的异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        String errorMessage = exception.getMessage();
        if (Strings.isNullOrEmpty(errorMessage)) {
            errorMessage = ExceptionUtils.getStackTrace(exception);
        }
        return Result.errorMessage(errorMessage);
    }


    private static JSONObject bussinessException;

    static {
        bussinessException = new JSONObject();
        bussinessException.put("code", 1);
        bussinessException.put("data", null);
    }

    /**
     * 处理 BizException 自定义异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BizException.class)
    public JSONObject handleBusinessException(BizException exception) {
        log.warn(exception.getMessage(), exception);
        bussinessException.put("message", exception.getMessage());
        return bussinessException;
    }


}