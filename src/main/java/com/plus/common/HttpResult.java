package com.plus.common;


import com.plus.base.DataType;
import com.plus.exception.ErrorEnum;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 *
 * @author AI
 */
@Getter
@Setter
@ToString
@ApiModel(description = "返回信息")
@NoArgsConstructor
public class HttpResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final HttpResult<Boolean> SUCCESS = new HttpResult<>(true);

    private T body;

    private boolean success;

    private String msg = DataType.STRING.getDesc();

    private int code;

    private int dataType = DataType.STRING.getCode();

    public HttpResult(T body) {
        this.body = body;
        this.success = true;
    }

    public HttpResult(BusinessWrapper<T> wrapper) {
        this.success = wrapper.isSuccess();
        if (wrapper.isSuccess()) {
            this.body = wrapper.getBody();
        } else {
            this.code = wrapper.getCode();
            this.msg = wrapper.getDesc();
        }
    }

    public HttpResult(ErrorEnum errorEnum) {
        this.success = false;
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMessage();
    }

    public HttpResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = false;
    }

    public HttpResult(int code, T body, String msg) {
        this.code = code;
        this.msg = msg;
        this.body = body;
        this.success = true;
    }

    public HttpResult(T body, int type, String msg) {
        this.dataType = type;
        this.msg = msg;
        this.body = body;
        this.success = true;
    }

    public static HttpResult errorEnum(ErrorEnum errorEnum) {
        return new HttpResult(errorEnum);
    }

    public static <T> HttpResult<T> error(final Integer code, final String msg) {
        return new HttpResult<T>(code, msg);
    }


    public static <T> HttpResult successResp(T body, DataType type) {
        return new HttpResult(body, type.getCode(), type.getDesc());
    }

    public static <T> HttpResult successStringResp(T body) {
        return HttpResult.successResp(body, DataType.STRING);
    }
}
