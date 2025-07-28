package com.itheima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {
    @Lazy
    @Autowired
    private ServiceA serviceA;
    public void getById()
    {
        System.out.println("***");
    }
    public  void add()
    {
        System.out.println("***");
    }
}
