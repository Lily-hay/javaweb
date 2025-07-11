package com.lily.Service.emplmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lily.entity.Emp;
import com.lily.entity.EmpQueryParam;
import com.lily.entity.PageBean;
import com.lily.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
/*f分页查询*/
@Service
public class EmpServicelmpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override

   /* public PageBean page( Integer page, Integer pageSize) {

        //1.获取总行数
        Long total=empMapper.count();
        //2.获取分页结果
        Integer start=(page-1)*pageSize;
        List<Emp> list=empMapper.page(start,pageSize);
        //3.包装
        return new PageBean(total,list);
    }*/

    //使用PageHelper改进
    /*public PageBean page( Integer page, Integer pageSize) {

        PageHelper.startPage(page,pageSize);

        List<Emp> emplist=empMapper.list();
        Page p=(Page) emplist;
        //3.包装
        return new PageBean(p.getTotal(),p.getResult());
    }*/

    public PageBean page( EmpQueryParam param)
    {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Emp> emplist=empMapper.list(param);
        Page p=(Page) emplist;
        //3.包装
        return new PageBean(p.getTotal(),p.getResult());
    }
}
