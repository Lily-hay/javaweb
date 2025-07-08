package com.lily;

import com.lily.entity.User;
import com.lily.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//会加载SpringBoot环境
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testList()
    {
        List<User> list = userMapper.list();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
