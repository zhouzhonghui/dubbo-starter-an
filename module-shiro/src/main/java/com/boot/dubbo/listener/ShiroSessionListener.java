package com.boot.dubbo.listener;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroSessionListener implements org.apache.shiro.session.SessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroSessionListener.class);

    @Override
    public void onStart(Session session) {
        LOGGER.info("会话创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        LOGGER.info("会话停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        LOGGER.info("会话过期：" + session.getId());
    }

}
