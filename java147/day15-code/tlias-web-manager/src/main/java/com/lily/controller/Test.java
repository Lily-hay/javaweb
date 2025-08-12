package com.lily.controller;

import com.lily.Dao.DeptDaolmpl;
import com.lily.Service.DeptServicelmpl;

public class Test {
    public static void main(String[] args) throws Exception {
        DeptServicelmpl deptService=new DeptServicelmpl();
        DeptDaolmpl deptDao=new DeptDaolmpl();
        System.out.println(deptService.list());
        //System.out.println(deptDao.daolmpl());

    }
}
