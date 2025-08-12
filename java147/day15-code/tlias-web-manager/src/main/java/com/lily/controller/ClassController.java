package com.lily.controller;

import com.lily.Service.classlmpl.ClassService;
import com.lily.entity.*;
import com.lily.mapper.ClassMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/clazzs")
    public Result page(ClassQueryParam classPar) {
        log.info("班级请求参数={}", classPar);
       PageBean pageBean=classService.page(classPar);
        return Result.success(pageBean);
    }
    @GetMapping("/clazzs/list")
    public Result list() {
        List<Clazz> clazzList=classService.list();
        return Result.success(clazzList);
    }
    @PostMapping("/clazzs")
    public Result add(@RequestBody Clazz clazz) {
        log.info("请求参数={}", clazz);
        classService.save(clazz);
        return Result.success();
    }
    @GetMapping("/clazzs/{id}")
    public Result getById(@PathVariable String id) {
        log.info("id={}",id);
        Clazz clazz=classService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping("/clazzs")
    public Result update(@RequestBody Clazz clazz) {
        log.info("班级参数={}",clazz);
        classService.update(clazz);
        return Result.success();
    }
    @DeleteMapping("/clazzs/{id}")
    public Result delete(@PathVariable String id) {
        log.info("id={}",id);
        try {
            classService.delete(id);
        } catch (Exception e) {
            return  Result.error("对不起, 该班级下有学生, 不能直接删除");
        }
        return Result.success();
    }

    @GetMapping("/report/studentCountData")
    public Result studentCountData() {
        CountList stuCount=classService.Count();
        return Result.success(stuCount);
    }
}
