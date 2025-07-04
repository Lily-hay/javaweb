package com.lily.Service;

import com.lily.Dao.DeptDaolmpl;
import com.lily.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//@Component
//@Primary//指定该类优先级最高
@Service("service2")
public class DeptServicelmpl2 implements DeptService {

    @Autowired

    private DeptDaolmpl deptDao;
    //DeptDaolmpl deptDao = new DeptDaolmpl();
    public List<Dept> listDept() throws Exception {
        List<Dept> depts = new ArrayList<>();
       List<String> strings= deptDao.daolmpl();
        for (String string : strings) {
            String[] parts = string.split(",");
            Integer id = Integer.valueOf(parts[0]);
            String name = parts[1];
            LocalDateTime time = LocalDateTime.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            depts.add(new Dept(id, name, time));
        }
        return depts;
    }
}
