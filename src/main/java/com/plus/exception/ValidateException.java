package com.plus.exception;

/**
 * 类ValidateException.java的实现描述:校验自定义异常处理类
 *
 */
public class ValidateException extends BaseException {

    private static final long serialVersionUID = 2729611264067131179L;

    public ValidateException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ValidateException(String errorMsg) {
        super(errorMsg);
    }

    public ValidateException(Throwable cause, String errorCode, String errorMsg) {
        super(cause, errorCode, errorMsg);
    }

    public ValidateException(Throwable cause, String errorMsg) {
        super(cause, errorMsg);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }
}
