package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询全部部门
     */
    @Select("select id, name, create_time, update_time from dept")
    public List<Dept> list();

    /**
     * 根据ID删除部门数据
     */
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    /**
     * 添加部门数据 - 传递多个参数时,可以把多个参数封装到一个对象中 , 然后通过 #{属性名} 来获取对象属性
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    /**
     * 根据ID查询部门数据
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 根据ID更新部门数据
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
