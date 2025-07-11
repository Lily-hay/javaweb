package com.lily.mapper;

import com.lily.entity.Emp;
import com.lily.entity.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**/
@Mapper
public interface EmpMapper {

   /* @Select("select count(*) from emp")
    Long count();
    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id limit #{start},#{pageSize}")
    List<Emp> page(Integer start, Integer pageSize);*/

    /*@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id")
    List<Emp> list();*/

    List<Emp> list(EmpQueryParam param);
}
