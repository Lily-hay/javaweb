package com.lily.mapper;

import com.lily.entity.Dept;
import org.apache.ibatis.annotations.*;

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

    @Delete("delete from dept where id=#{id}")
    void delete(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void save(Dept dept);

    @Select("select * from dept where id=#{id}")
    Dept getById(Integer id);

    /*根据id修改数据*/
    //@Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
