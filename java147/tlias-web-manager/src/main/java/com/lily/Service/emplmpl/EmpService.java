package com.lily.Service.emplmpl;

import com.lily.entity.Emp;
import com.lily.entity.EmpLoginInfo;
import com.lily.entity.EmpQueryParam;
import com.lily.entity.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean page(EmpQueryParam empPar);

    void save(Emp emp) throws Exception;

    void delete(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    EmpLoginInfo login(Emp emp);


    //PageBean page(Integer page, Integer pageSize);


}
