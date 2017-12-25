package com.boot.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author xiaofei.wxf(teaey)
 * @since 0.0.0
 */
@Service(version = "1.0.0",timeout = 600000)
public class EchoServerImpl implements EchoService {



    @Override
    public String echo(String str) {
        System.out.println(str);
        return str;
    }

    @Override
    public String test(String str) {
        System.out.println("这是一个测试==" + str+",");
        return null;
    }
}
