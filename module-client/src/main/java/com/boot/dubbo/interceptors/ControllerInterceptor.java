package com.boot.dubbo.interceptors;


import com.boot.dubbo.domain.BaseRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerInterceptor {

    /**
     * 定义拦截规则：拦截com.boot.dubbo.controller包下面的所有类中，有@RequestMapping注解的方法。 
     */
    @Pointcut("execution(* com.boot.dubbo.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器实现
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("controllerMethodPointcut()")
    public Object Interceptor(ProceedingJoinPoint point) throws Throwable {
        Object[] objects = point.getArgs() ;
        for (Object o : objects){
            if(o instanceof BaseRequest){
                BaseRequest request = (BaseRequest) o;
                request.setVersion("212");
            }
        }

       return point.proceed() ;
    }
}
