package com.lily.Service.emplmpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lily.entity.*;
import com.lily.mapper.EmpExprMapper;
import com.lily.mapper.EmpMapper;
import com.lily.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.testng.collections.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*f分页查询*/
@Slf4j
@Service
public class EmpServicelmpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;


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

    @Transactional(rollbackFor = Exception.class)//开启事务，指定处理最大异常，默认只处理RunningTime Exception
    @Override
    public void save(Emp emp) throws Exception {
        try {
            //1.调用mapper的函数，新增员工信息
            //1.1 补全未传入的参数
            emp.setPassword("123456");
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            //2.1.调用mapper的函数，新增员工工作经历
            empMapper.insert(emp);
            Integer id=emp.getId();
            log.info("id={}",id);

            //模拟运行时异常
            /*if(true)
            {
                throw new Exception("出错了！");
            }*/

            List<EmpExpr> exprList=emp.getExprList();

            if(!exprList.isEmpty())
            {
                exprList.forEach((expr->{
                    expr.setEmpId(id);
                }));
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            EmpLog empLog=new EmpLog();
            empLog.setOperateTime(LocalDateTime.now());
            empLog.setInfo("输入员工信息"+emp);
            empLogService.insertLog(empLog);
        }

    }

    @Transactional
    @Override
    public void delete(List<Integer> ids) {
        //1.批量删除员工信息
        empMapper.deleteBatch(ids);

        //2.批量删除员工经历
        empExprMapper.deleteBatch(ids);
    }

    @Override
    public Emp getById(Integer id) {
        //1.方式一 获取员工信息和员工经历
       // return empMapper.getById(id);
        //方式二
        //1.查询员工基本信息
        Emp emp=empMapper.getById2(id);
        //2.查询员工经历
        List<EmpExpr> exprList=empExprMapper.getEmpbyId(id);
        emp.setExprList(exprList);
        return emp;
    }

    @Transactional
    @Override
    public void update(Emp emp) {
        //1.更新员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);

        //2.更新员工经历
        //1.根据先id删除，再根据新增
        empExprMapper.delete(emp.getId());
        List<EmpExpr> empExprList=emp.getExprList();
        if(!empExprList.isEmpty())//如果集合为空，sql语句会报错
        {
            empExprList.forEach((expr)->{
                expr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(emp.getExprList());
        }
    }

    @Override
    public EmpLoginInfo login(Emp emp) {
        //1.调mapper查询员工
        Emp empDB=empMapper.login(emp);
        //2.判断用户名密码是否正确
        if(empDB!=null)
        {
            //生成令牌
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",empDB.getId());
            claims.put("username",empDB.getUsername());
            String jwt= JwtUtils.generateJwt(claims);
            return new EmpLoginInfo(empDB.getId(),empDB.getUsername(),empDB.getName(),jwt);
        }

        //如果用户名密码为空，直接返回null
        return null;
    }


}
