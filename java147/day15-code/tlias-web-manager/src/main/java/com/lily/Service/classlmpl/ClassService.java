package com.lily.Service.classlmpl;

import com.lily.entity.*;

import java.time.LocalDate;
import java.util.List;

public interface ClassService {

    PageBean page(ClassQueryParam classPar);

    void save(Clazz clazz);

    List<Clazz> list();

    Clazz getById(String id);

    void update(Clazz clazz);

    void delete(String id);

    CountList Count();
}
