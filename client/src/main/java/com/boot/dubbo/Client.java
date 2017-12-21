package com.boot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaofei.wxf(teaey)
 * @since 0.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.boot.dubbo"})
public class Client {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Client.class, args);
//        AbcService bean = run.getBean(AbcService.class);
//        System.out.println(bean.echoService.echo("abccc"));
//
//        bean.echoService.test("sdhjhd shdjh是点击返回数据") ;
    }
}
