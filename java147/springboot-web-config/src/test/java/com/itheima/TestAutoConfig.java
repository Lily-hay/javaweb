package com.itheima;

import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.MyImportSelector;
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
    public void testTokenParser() {
        TokenParser tokenParser = context.getBean(TokenParser.class);
        System.out.println("tokenParser = " + tokenParser);
    }
    @Test
    public void testHeaderGenerator() {
        HeaderGenerator headerGenerator = context.getBean(HeaderGenerator.class);
        System.out.println("headerGenerator = " + headerGenerator);
    }
    @Test
    public void testHeaderParser() {
        HeaderParser headerParser = context.getBean(HeaderParser.class);
        System.out.println("headerParser = " + headerParser);
    }

}
