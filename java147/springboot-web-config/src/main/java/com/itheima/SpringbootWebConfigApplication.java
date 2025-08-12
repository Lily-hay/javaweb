package com.itheima;

import com.example.*;
import org.apache.el.parser.Token;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
//@EnableHeaderConfig//封装import注解
@Import(MyImportSelector.class)//导入接口实现类
//@Import(HeaderConfig.class)//导入配置类
//@Import({HeaderGenerator.class, HeaderParser.class})//导入普通类
//@Import(TokenParser.class)
//@ComponentScan({"com.example","com.itheima"})

@SpringBootApplication
public class SpringbootWebConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfigApplication.class, args);
    }
}
