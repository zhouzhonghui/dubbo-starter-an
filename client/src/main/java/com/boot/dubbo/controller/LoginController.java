package com.boot.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.dubbo.domain.LoginRequest;
import com.boot.dubbo.domain.LoginResponse;
import com.boot.dubbo.service.EchoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/login", consumes = "application/json", produces = "application/json")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Reference(version = "1.0.0")
    public EchoService echoService;

    /**
     * 登录
     * @param request
     * @return
     */
    @PostMapping(path = "/login/1.0.0")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        logger.info("----------login----------sessionId===========" , sessionId);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(request.getClientId(), request.getPasswd());
        subject.login(usernamePasswordToken);


        LoginResponse response = new LoginResponse();

        BeanUtils.copyProperties(request, response);

        echoService.test(request.getName());


        return response;
    }

    /**
     * 测试权限
     * @param request
     * @return
     */
    @PostMapping(path = "/testPermisson/1.0.0")
    @RequiresPermissions("oauth2:test:read")
    public LoginResponse testPermisson(@RequestBody @Valid LoginRequest request) {

        LoginResponse response = new LoginResponse();

        BeanUtils.copyProperties(request, response);

        echoService.test(request.getName());


        return response;
    }
}
