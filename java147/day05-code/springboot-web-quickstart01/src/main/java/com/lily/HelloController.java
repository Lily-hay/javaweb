package com.lily;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//标识当前类是一个请求处理类
public class HelloController {
    @RequestMapping("/hello")//设置请求路径
    public String hello() {
        System.out.println("hello........");
        return "Hello~";
    }
}
