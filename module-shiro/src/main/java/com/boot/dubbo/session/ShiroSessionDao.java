package com.boot.dubbo.session;

import com.boot.dubbo.service.RedisService;
import com.boot.dubbo.utils.SerializableUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class ShiroSessionDao extends CachingSessionDAO {
    private static final Logger logger = LoggerFactory.getLogger(ShiroSessionDao.class);
    private static final String SHIRO_SESSION_ID = "shiro-session-id";

    @Autowired
    private RedisService redisService;


    @Override
    protected void doUpdate(Session session) {
        // 如果会话过期/停止 没必要再更新了
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            logger.info("session or session id is timeout");
            return;
        }

        // 更新session的最后一次访问时间
        ShiroSession shiroSession = (ShiroSession) session;
        ShiroSession cacheShiroSession = (ShiroSession) doReadSession(session.getId());
        if (null != cacheShiroSession) {
            shiroSession.setStatus(cacheShiroSession.getStatus());
            shiroSession.setAttribute("FORCE_LOGOUT", cacheShiroSession.getAttribute("FORCE_LOGOUT"));
        }

        logger.info("更新 >>>>> sessionId={}", session.getId());
        redisService.set(SHIRO_SESSION_ID + "_" + shiroSession.getId(), SerializableUtil.serialize(session), session.getTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override
    protected void doDelete(Session session) {
        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }

        logger.info("删除 >>>>> sessionId={}", session.getId());
        redisService.delete(SHIRO_SESSION_ID + "_" + session.getId());
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        logger.info("新增 >>>>> sessionId={}", sessionId);
        redisService.set(SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(session), session.getTimeout(), TimeUnit.MILLISECONDS);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.info("读取 >>>>> sessionId={}", sessionId);

        String session = (String) redisService.get(SHIRO_SESSION_ID + "_" + sessionId);
        return SerializableUtil.deserialize(session);
    }
}
