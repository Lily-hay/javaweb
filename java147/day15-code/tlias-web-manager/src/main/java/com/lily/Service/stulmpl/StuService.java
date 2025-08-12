package com.lily.Service.stulmpl;

import com.lily.entity.Degree;
import com.lily.entity.PageBean;
import com.lily.entity.StuQueryParam;
import com.lily.entity.Student;

import java.util.List;

public interface StuService {
    List<Degree> getCountByDegree();

    PageBean page(StuQueryParam stuQueryParam);

    void save(Student stu);

    Student getById(Integer id);

    void update(Student stu);

    void delete(Integer[] ids);

    void violation(Integer id, Integer score);

    Short getScore(Integer id);
}
