package com.boot.dubbo.factory;

import com.boot.dubbo.session.ShiroSession;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import javax.servlet.http.HttpServletRequest;

public class ShiroSessionFactory implements org.apache.shiro.session.mgt.SessionFactory {

    @Override
    public Session createSession(SessionContext sessionContext) {
        ShiroSession session = new ShiroSession();
        if (null != sessionContext && sessionContext instanceof WebSessionContext) {
            WebSessionContext webSessionContext = (WebSessionContext) sessionContext;
            HttpServletRequest request = (HttpServletRequest) webSessionContext.getServletRequest();
            if (null != request) {
                session.setHost(request.getRemoteAddr());
                session.setUserAgent(request.getHeader("User-Agent"));
            }
        }
        return session;
    }

}
