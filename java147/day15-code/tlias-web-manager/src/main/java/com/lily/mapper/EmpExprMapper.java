package com.lily.mapper;

import com.lily.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    //用xml开发实现新增员工经历

    void insertBatch(List<EmpExpr> exprList);

    void deleteBatch(List<Integer> empIds);

    List<EmpExpr> getEmpbyId(Integer id);

    void delete(Integer id);
}
