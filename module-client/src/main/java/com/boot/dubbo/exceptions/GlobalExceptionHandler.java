package com.boot.dubbo.exceptions;

import com.boot.dubbo.exceptions.response.*;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
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
     *
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
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleException(MethodArgumentNotValidException e) {
        logger.error("==============================ExceptionMapperSupport============================", e);
        ErrorResponse errorResponse = new ConstraintViolationResponse(locale, e);
        return errorResponse;
    }

    /**
     * 未登录
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public ErrorResponse handleException(UnauthenticatedException e) {
        logger.error("==============================ExceptionMapperSupport============================", e);
        ErrorResponse errorResponse = new AuthenticatedResponse(locale);
        return errorResponse;
    }

    /**
     * 没有权限
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ErrorResponse handleException(UnauthorizedException e) {
        logger.error("==============================ExceptionMapperSupport============================", e);
        ErrorResponse errorResponse = new AuthorizedResponse(locale, e.getMessage());
        return errorResponse;
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ErrorResponse handleException(BusinessException e) {
        logger.error("==============================ExceptionMapperSupport============================", e);
        ErrorResponse errorResponse = new BusinessErrorResponse(locale, e);
        return errorResponse;
    }

    /**
     * oauth2验证
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Oauth2Exception.class)
    public ErrorResponse handleException(Oauth2Exception e) {
        logger.error("==============================ExceptionMapperSupport============================", e);
        ErrorResponse errorResponse = new Oauth2ErrorResponse(locale, e);
        return errorResponse;
    }
}
