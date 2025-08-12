package com.lily.controller;

import com.lily.Service.emplmpl.EmpService;
import com.lily.entity.Emp;
import com.lily.entity.EmpLoginInfo;
import com.lily.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("username={},password={}",emp.getUsername(),emp.getPassword());
        EmpLoginInfo empLoginInfo=empService.login(emp);
        if(empLoginInfo==null){
            return Result.error("用户名或密码错误");
        }
        return Result.success(empLoginInfo);
    }
}
