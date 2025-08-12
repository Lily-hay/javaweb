package com.lily.controller;

import com.lily.Service.stulmpl.StuService;
import com.lily.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class StuController {
    @Autowired
    private StuService stuService;
    @GetMapping("/students")
    public Result page(StuQueryParam stuQueryParam){
        log.info("请求参数={}",stuQueryParam);
        PageBean pageBean=stuService.page(stuQueryParam);
        return Result.success(pageBean);
    }

    @PostMapping("/students")
    public Result save(@RequestBody Student stu){
        log.info("student={}",stu);
        stuService.save(stu);
        return Result.success();
    }

    @GetMapping("/students/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("id={}",id);
        Student stu=stuService.getById(id);
        return Result.success(stu);
    }
    @PutMapping("/students")
    public Result update(@RequestBody Student stu){
        log.info("stu={}",stu);
        stuService.update(stu);
        return Result.success();
    }

    @DeleteMapping("/students/{ids}")
    public Result delete(@PathVariable Integer[] ids){
        log.info("ids={}", ids);
        stuService.delete(ids);
        return Result.success();
    }
    @GetMapping("/students/violation/{id}")
    public Result getScore(@PathVariable Integer id){
        log.info("id={}",id);
        Short score=stuService.getScore(id);
        return Result.success(score);
    }
    @PutMapping("/students/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score){
        log.info("id={},score={}",id,score);
        stuService.violation(id,score);
        return Result.success();
    }

    @GetMapping("/report/studentDegreeData")
    public Result getDegreeData(){
        List<Degree> degreelist=stuService.getCountByDegree();
        return Result.success(degreelist);
    }
}
