package com.lily.controller;

import com.lily.Service.emplmpl.EmpService;
import com.lily.entity.Emp;
import com.lily.entity.EmpQueryParam;
import com.lily.entity.PageBean;
import com.lily.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;
    /*
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10")  Integer pageSize){
        PageBean pageBean=empService.page(page,pageSize);
        log.info("page={},pageSize={}",page,pageSize);
        return Result.success(pageBean);
    }
    */

    /*
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Integer gender, @DateTimeFormat(pattern = "YYYY-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "YYYY-MM-dd")  LocalDate end ) {
        PageBean pageBean=empService.page(page,pageSize,name,gender,begin,end);
        log.info("请求参数={}，{}，{}，{}，{}，{}",page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    */

    /*查询*/
    @GetMapping("/emps")
    public Result page(EmpQueryParam empPar) {
        PageBean pageBean=empService.page(empPar);
        log.info("请求参数={}，{}，{}，{}，{}，{}",empPar.getPageSize(), empPar.getPageSize(), empPar.getName(),
                empPar.getGender(), empPar.getBegin(),empPar.getEnd());
        return Result.success(pageBean);
    }

    /*新增员工*/
    @PostMapping("/emps")
    public Result save1(@RequestBody Emp emp) throws Exception {
        empService.save(emp);
        //log.info("请求参数={}",emp.toString());
        return Result.success();
    }

    @DeleteMapping("/emps")
    //传入参数1： 直接用数组接
    //public Result delete(Integer[] ids)
    //传入参数2：用集合来接，方便后续操作
     public Result delete(@RequestParam List<Integer> ids)
    {
        log.info("ids={}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        log.info("回显id={}", id);
        Emp emp=empService.getById(id);
        return Result.success(emp);
    }
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp) {
        log.info("emp={}", emp);
        empService.update(emp);
        return Result.success();
    }

}
