package com.itheima;

import org.apache.http.message.TokenParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class TestAutoConfig {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testAutoConfig() {
        TokenParser bean = context.getBean(TokenParser.class);
        System.out.println("bean = " + bean);
    }
}
