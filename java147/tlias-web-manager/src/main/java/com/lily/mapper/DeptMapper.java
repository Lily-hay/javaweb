package com.lily.mapper;

import com.lily.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    //数据封装
    //1.手动结果映射
    /*@Results
            ({
                    @Result(column="create_time",property = "createTime"),
                    @Result(column="update_time",property = "updateTime"),

            }
            )*/
    //2.数据封装2，起别名
    //@Select("select id,name,create_time createTime,update_time updateTime from dept")

    //数据封装方式3 全局配置，开启驼峰命名规则映射
    @Select("select * from dept")
    public List<Dept> list();
}
