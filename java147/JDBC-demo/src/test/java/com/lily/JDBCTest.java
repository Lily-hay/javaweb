package com.lily;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Collection;

public class JDBCTest {
    @Test
    public void testUpdate() throws Exception {
        //1、准备工作
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java147_db02","root","13145");
        //获取执行对象
        Statement statement = connection.createStatement();
        //2、执行SQL语句
        int i = statement.executeUpdate("update user set password='12345678'where id=1");
        System.out.println("i=="+i);
        //3、释放资源
    }
}
