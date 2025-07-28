package com.lily.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lily.Service.stulmpl.StuService;
import com.lily.entity.Degree;
import com.lily.entity.PageBean;
import com.lily.entity.StuQueryParam;
import com.lily.entity.Student;
import com.lily.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StuServicelmpl implements StuService {
    @Autowired
    private  StuMapper stuMapper;


    @Override
    public List<Degree> getCountByDegree() {
        List<Degree> degreelist=stuMapper.getCountByDegree();
        return degreelist;
    }

    @Override
    public PageBean page(StuQueryParam stuQueryParam) {
        PageHelper.startPage(stuQueryParam.getPage(),stuQueryParam.getPageSize());
        List<Student> studentList=stuMapper.page(stuQueryParam);
        Page p=(Page) studentList;
        return new  PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Student stu) {
        stu.setViolationCount(Short.valueOf("0"));
        stu.setViolationScore(Short.valueOf("0"));
        stu.setCreateTime(LocalDateTime.now());
        stu.setUpdateTime(stu.getCreateTime());
        stuMapper.save(stu);
    }

    @Override
    public Student getById(Integer id) {
        Student stu=stuMapper.getById(id);

        return stu;
    }

    @Override
    public void update(Student stu) {
        stu.setUpdateTime(LocalDateTime.now());
        stuMapper.update(stu);
    }

    @Override
    public void delete(Integer[] ids) {
        stuMapper.delete(ids);

    }

    @Override
    public void violation(Integer id, Integer score) {
        stuMapper.violation(id,score);
    }

    @Override
    public Short getScore(Integer id) {

        return stuMapper.getScore(id);
    }
}
