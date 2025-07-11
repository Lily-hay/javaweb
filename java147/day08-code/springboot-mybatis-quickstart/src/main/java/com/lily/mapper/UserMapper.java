package com.lily.mapper;

import com.lily.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//作用，程序启动时，会自动生成该接口的代理对象，交由IOC容器管理
public interface UserMapper {
    //@Select("select * from user")
    public List<User> list();
}
