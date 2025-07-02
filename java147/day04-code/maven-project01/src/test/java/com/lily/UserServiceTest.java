package com.lily;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserServiceTest {
    @DisplayName("测试年龄")
    @ParameterizedTest //参数化测试
    @ValueSource(strings={"138937200305062829","138937200105062829","138937200205062829"})
    public void testGetAge(String id)
    {
        Integer age=new UserService().getAge(id);
        System.out.println("age:"+age);
    }
    @DisplayName("测试性别")
    @ParameterizedTest
    @ValueSource(strings={"138937200305062829","138937200105062829","138937200205062836"})
    public void testGetGender(String id)
    {
        String gender=new UserService().getGender(id);
        System.out.println("gender:"+gender);
    }
}
