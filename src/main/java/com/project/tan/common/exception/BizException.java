package com.project.tan.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 自定义业务异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //存取器，@Accessors用于配置getter和setter方法的生成结果
public class BizException extends RuntimeException {

    private String message;

//    public BizException() {
//    }
//
//    public BizException(String message) {
//        this(message, (Throwable) null);
//    }
//
//    public BizException(Throwable cause) {
//        this((String) null, cause);
//    }
//
//    public BizException(String message, Throwable cause) {
//        super(message, cause);
//        this.message = message;
//    }

}
