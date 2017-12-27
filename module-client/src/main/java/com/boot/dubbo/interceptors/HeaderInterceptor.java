package com.boot.dubbo.interceptors;

import com.boot.dubbo.domain.BaseRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

public class HeaderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String accept = httpServletRequest.getHeader("Accept");
        Map map = httpServletRequest.getParameterMap() ;
        HandlerMethod handlerMethod = (HandlerMethod) o;
        MethodParameter methodParameter = handlerMethod.getMethodParameters()[0] ;
        Method m = handlerMethod.getMethod() ;
        Parameter parameter = m.getParameters()[0] ;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
