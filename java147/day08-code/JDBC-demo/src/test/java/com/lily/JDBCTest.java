package com.lily;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.*;
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
        statement.close();
        connection.close();
    }
    @ParameterizedTest
    @CsvSource(value={"xiaoqiao,123456","zhangsan,'or '1'='1"})
    public void testSearch(String uname,String pwd) throws Exception {
        //1、准备工作
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java147_db02","root","13145");
        //获取执行对象
        Statement statement = connection.createStatement();
        //2、执行SQL语句
        ResultSet resultSet = statement.executeQuery("select * from user where username='"+uname+"' and password='"+pwd+"'");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name=resultSet.getString("name");
            int  age = resultSet.getInt("age");
            User user = new User(id,username,password,name,age);
            System.out.println(user);
        }

        //3、释放资源
        statement.close();
        connection.close();
    }

    @ParameterizedTest
    @CsvSource(value={"xiaoqiao,123456","zhangsan,'or '1'='1"})
    public void testSearch2(String uname,String pwd) throws Exception {
        //1、准备工作
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java147_db02","root","13145");
        //获取执行对象
        PreparedStatement ps = connection.prepareStatement("select * from user where username=? and password=?");
        //设置参数       ?表示占位符，参数传入后会做转义，看作了一个整体
        ps.setString(1,uname);
        ps.setString(2,pwd);

        //2、执行SQL语句
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name=resultSet.getString("name");
            int  age = resultSet.getInt("age");
            User user = new User(id,username,password,name,age);
            System.out.println(user);
        }

        //3、释放资源
        ps.close();
        connection.close();
    }
}
