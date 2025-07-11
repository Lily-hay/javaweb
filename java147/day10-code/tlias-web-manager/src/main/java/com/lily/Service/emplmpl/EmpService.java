package com.lily.Service.emplmpl;

import com.lily.entity.EmpQueryParam;
import com.lily.entity.PageBean;

import java.time.LocalDate;

public interface EmpService {

    PageBean page(EmpQueryParam empPar);
    //PageBean page(Integer page, Integer pageSize);

}
