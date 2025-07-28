package com.itheima.config;

import com.itheima.service.ServiceB;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//声明是配置类
public class CommonConfig {
    @Bean("SAXReader")   //作用：程序启动时，会执行该方法，并将方法的返回值对象交由IOC容器管理
    //bean的名字默认是方法名，可以通过name/value属性改名字
    public SAXReader saxReader(ServiceB serviceB) {
        return new SAXReader();
    }
}
