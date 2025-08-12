package com.lily.Service.classlmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lily.entity.*;
import com.lily.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiselmpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public PageBean page(ClassQueryParam classPar) {
        PageHelper.startPage(classPar.getPage(), classPar.getPageSize());
        List<Clazz> classList=classMapper.page(classPar);
        Page p=(Page) classList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Clazz  clazz) {
        clazz.setCreateTime(LocalDateTime.now());


        clazz.setUpdateTime(LocalDateTime.now());
        classMapper.save(clazz);
    }

    @Override
    public List<Clazz> list() {
        List<Clazz> clazzList=classMapper.list();
        return clazzList;
    }

    @Override
    public Clazz getById(String id) {
       Clazz clazz=classMapper.getById(id);
        return clazz;
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        classMapper.update(clazz);
    }

    @Override
    public void delete(String id) {
        //1.删除班级
        classMapper.delete(id);
    }

    @Override
    public CountList Count() {
        List<String> clazz =new ArrayList<>();
        List<Integer> data =new ArrayList<>();
        List<StuCount> stuCountList=classMapper.Count();
        CountList countList=new CountList();
        for (StuCount stuCount : stuCountList) {
            clazz.add(stuCount.getName());
            data.add(stuCount.getData());
        }
        countList.setClazzList(clazz);
        countList.setDataList(data);
        return countList;
    }

}
