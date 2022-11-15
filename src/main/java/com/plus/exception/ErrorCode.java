package com.plus.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ErrorCode.java
 * @Description 功能描述： 异常返回码定义枚举
 */
public enum ErrorCode {
    /**
     * 参数不存在
     */
    PARAM_NOT_FOUND("40001", "参数不存在"),

    /**
     * 参数值为NULL或空字符串
     */
    PARAM_IS_NULL("40002", "参数值为NULL或空字符串"),

    /**
     * 用户金币不足
     */
    COINS_NOT_ENOUGH("40003", "用户金币不足"),

    /**
     * 请求头Authorization中的token为NULL或空字符串
     */
    TOKEN_IS_NULL("40101", "请求头Authorization中的token为NULL或空字符串"),

    /**
     * 请求头Authorization中的token已过期
     */
    TOKEN_EXPIRED("40102", "请求头Authorization中的token已过期"),

    /**
     * sessionKey已过期或错误
     */
    SESSION_KEY_ERROR("40103", "sessionKey已过期或错误"),

    /**
     * openId不匹配
     */
    OPENID_NOT_MATCH("40104", "openId不匹配"),

    /**
     * jsCode已过期或错误
     */
    JSCODE_ERROR("40105", "jsCode已过期或错误"),

    /**
     * shareToken已过期或错误
     */
    SHARE_TOKEN_ERROR("40106", "shareToken已过期或错误"),

    /**
     * 文件超出最大限制
     */
    MAX_FILE_SIZE("41301", "文件超出最大限制"),

    /**
     * 短时间内重复访问接口
     */
    NOT_REPEAT_REQUEST("42301", "短时间内重复访问接口");

    private String errorCode;

    private String errorMessage;

    /**
     * @param errorCode
     * @param errorMessage
     */
    private ErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 所有状态
     *
     * @return
     */
    public static Map<String, String> getAllState() {
        ErrorCode[] sts = ErrorCode.values();
        Map<String, String> maps = new HashMap<String, String>();
        for (ErrorCode tmp : sts) {
            maps.put(tmp.errorCode, tmp.errorMessage);
        }
        return maps;
    }

}
