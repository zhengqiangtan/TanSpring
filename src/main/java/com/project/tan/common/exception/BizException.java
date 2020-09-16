package com.project.tan.common.exception;


public class BizException extends RuntimeException {

    private String message;

    public BizException() {
    }

    public BizException(String message) {
        this(message, (Throwable) null);
    }

    public BizException(Throwable cause) {
        this((String) null, cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
