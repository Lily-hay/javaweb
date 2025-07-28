package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import com.itheima.service.impl.DeptServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
//@Lazy
@Scope("prototype")
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    private DeptController(){
        System.out.println("bean对象创建了......");
    }

    @Autowired
    private DeptService deptService;
    /**
     * 查询全部部门
     */
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.queryDeptList();
        return Result.success(deptList);
    }

    /**
     * 根据ID删除部门
     */
    @DeleteMapping
    public Result delete(Integer id){
        log.info("根据ID删除部门: {}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 添加部门 - json格式参数接收
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门: {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据ID查询部门数据
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询部门数据: {}", id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }

    /**
     * 修改部门数据
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门数据: {}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
