package com.lily.mapper;

import com.lily.entity.Emp;
import com.lily.entity.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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

    @Options(useGeneratedKeys = true,keyProperty = "id") //可以获取新生成的id
    @Insert("insert into emp values (null,#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

}
