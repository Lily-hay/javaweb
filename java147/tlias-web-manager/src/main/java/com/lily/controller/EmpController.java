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

    @GetMapping("/emps")
    public Result page(EmpQueryParam empPar) {
        PageBean pageBean=empService.page(empPar);
        log.info("请求参数={}，{}，{}，{}，{}，{}",empPar.getPageSize(), empPar.getPageSize(), empPar.getName(),
                empPar.getGender(), empPar.getBegin(),empPar.getEnd());
        return Result.success(pageBean);
    }

    @PostMapping("/emps")
    public Result save1(@RequestBody Emp emp) {
        empService.save(emp);
        //log.info("请求参数={}",emp.toString());
        return Result.success();
    }



}
