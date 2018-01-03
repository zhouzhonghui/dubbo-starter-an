package com.boot.dubbo.exceptions;

import com.boot.dubbo.exceptions.response.ConstraintViolationResponse;
import com.boot.dubbo.exceptions.response.ErrorResponse;
import com.boot.dubbo.exceptions.response.UncaughtExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private final Locale locale = LocaleContextHolder.getLocale();
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 未捕获异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        logger.error("==============================ExceptionMapperSupport============================", e);
        ErrorResponse errorResponse = new UncaughtExceptionResponse(locale, e);
        return errorResponse;
    }

    /**
     * 请求参数异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleException(MethodArgumentNotValidException e) {
        logger.error("==============================ExceptionMapperSupport============================", e);
        ErrorResponse errorResponse = new ConstraintViolationResponse(locale, e);
        return errorResponse;
    }

}
