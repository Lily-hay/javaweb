package com.lily.mapper;

import com.lily.entity.Degree;
import com.lily.entity.StuQueryParam;
import com.lily.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuMapper {
    List<Student> page(StuQueryParam stuQueryParam);

    void save(Student stu);

    @Select("select * from student where id=#{id}")
    Student getById(Integer id);

    void update(Student stu);

    void delete(Integer[] ids);

    void violation(Integer id, Integer score);

    Short getScore(Integer id);

    List <Degree> getCountByDegree();
}
