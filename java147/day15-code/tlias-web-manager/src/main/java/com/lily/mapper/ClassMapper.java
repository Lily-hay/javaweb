package com.lily.mapper;

import com.lily.entity.ClassQueryParam;
import com.lily.entity.Clazz;
import com.lily.entity.StuCount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper {

    //动态sql
    List<Clazz> page(ClassQueryParam classPar);


    void save(Clazz clazz);

    @Select("select * from clazz")
    List<Clazz> list();

    @Select("select * from clazz where id=#{id}")
    Clazz getById(String id);

    //动态sql查询
    void update(Clazz clazz);

    void delete(String id);

    List<StuCount> Count();
}
