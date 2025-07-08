package com.lily.Service;

import com.lily.Dao.DeptDaolmpl;
import com.lily.entity.Dept;
import com.lily.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
//@Component
@Service
public class DeptServicelmpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    public List<Dept> list() {
        return deptMapper.list();
    }

}
