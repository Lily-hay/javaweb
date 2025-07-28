package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询所有的部门数据
    public List<Dept> queryDeptList();

    //根据ID删除部门数据
    void delete(Integer id);

    //添加部门数据
    void add(Dept dept);

    //根据ID查询部门数据
    Dept getInfo(Integer id);

    //根据ID修改部门数据
    void update(Dept dept);
}
