package com.plus.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

/**
 * @ClassName: GlobalControllerExceptionHandler
 * @Description:
 * @author: AI
 * @date: 2019/5/7  11:41
 */
@ControllerAdvice()
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler()
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private void runtimeExceptionHandler(Exception e) {

        log.error(e.getMessage(), e);
//        sendMessage(e);
    }

    @Async
    public void sendMessage(Exception e) {
        // 发送钉钉通知开发者
//        DingDingUtils.sendTextMessage(ExceptionUtil.stacktraceToString(e,1000,null));
    }

    @ExceptionHandler(ValidateException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private String ValidateExceptionHandler(ValidateException e) {
        return e.getMessage();
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private void AuthException(AuthException e) {
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private String BindException(BindException e) {
        return Objects.requireNonNull(e.getFieldError()).getDefaultMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private String MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldError().getDefaultMessage();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private String MissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return e.getMessage();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private String HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        sendMessage(e);
        return e.getMessage();
    }

}
