package com.lily.Service.emplmpl;

import com.lily.entity.Emp;
import com.lily.entity.EmpQueryParam;
import com.lily.entity.PageBean;

import java.time.LocalDate;

public interface EmpService {

    PageBean page(EmpQueryParam empPar);

    void save(Emp emp);
    //PageBean page(Integer page, Integer pageSize);

}
