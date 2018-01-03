package com.boot.dubbo.exceptions;

import com.boot.dubbo.exceptions.response.ConstraintViolationResponse;
import com.boot.dubbo.exceptions.response.ErrorResponse;
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

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        e.printStackTrace();
        return null ;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        ErrorResponse errorResponse = new ConstraintViolationResponse(locale, e);
        return errorResponse;
    }

}
