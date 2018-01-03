package com.boot.dubbo.interceptors;


import com.boot.dubbo.domain.BaseRequest;
import com.boot.dubbo.util.ThreadLocalUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String clientId = httpServletRequest.getHeader("clientId") ;
        String clientChnl = httpServletRequest.getHeader("clientChnl") ;
        String requestURI = httpServletRequest.getRequestURI() ;
        String[] stringArr = requestURI.split("/") ;

        BaseRequest request = new BaseRequest() ;
        request.setClientId(clientId);
        request.setClientChnl(clientChnl) ;
        request.setResource(stringArr[1]);
        request.setServerName(stringArr[2]);
        request.setVersion(stringArr[3]);
        ThreadLocalUtil.set(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        ThreadLocalUtil.reset();
    }
}
