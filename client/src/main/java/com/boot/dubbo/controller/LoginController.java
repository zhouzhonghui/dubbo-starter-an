package com.boot.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.dubbo.domain.LoginRequest;
import com.boot.dubbo.domain.LoginResponse;
import com.boot.dubbo.service.EchoService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/login", consumes = "application/json", produces = "application/json")
public class LoginController {

    @Reference(version = "1.0.0")
    public EchoService echoService;

    @PostMapping(path = "/login/1.0.0")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {

        LoginResponse response = new LoginResponse();

        BeanUtils.copyProperties(request, response);

        echoService.test(request.getName());


        return response;

    }
}
