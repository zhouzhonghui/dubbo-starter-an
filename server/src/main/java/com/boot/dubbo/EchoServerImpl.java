package com.boot.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.boot.dubbo.EchoService;

/**
 * @author xiaofei.wxf(teaey)
 * @since 0.0.0
 */
@Service(version = "1.0.0")
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
