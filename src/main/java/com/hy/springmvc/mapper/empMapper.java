package com.hy.springmvc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.springmvc.pojo.Emp;
import com.hy.springmvc.pojo.EmpDept;
import com.hy.springmvc.sql.empSQL;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface empMapper extends BaseMapper<Emp> {

    @Results({
            @Result(column="eid",property="eid"),
            @Result(column="ename",property="ename"),
            @Result(column="sex",property="sex"),
            @Result(column="did",property="did"),
            @Result(column="birthday",property="birthday"),
            @Result(column="sal",property="sal"),
            @Result(column="did",property="did"),
            @Result(column = "dname",property ="dname"),
            @Result(column = "city",property ="city")
    })
    @Select("select * from emp e left join dept d on e.did=d.did ")
    public List<EmpDept> queryEmpDept();

    @SelectProvider(type = empSQL.class,method = "query")
    public IPage<EmpDept> querylist(Page page, @Param("em")Emp emp);

    @SelectProvider(type = empSQL.class,method = "queryBy")
    public EmpDept queryBy(Emp emp);

    @Results({
            @Result(column="eid",property="eid"),
            @Result(column="ename",property="ename"),
            @Result(column="sex",property="sex"),
            @Result(column="did",property="did"),
            @Result(column="birthday",property="birthday"),
            @Result(column="sal",property="sal"),
            @Result(column="did",property="did"),
            @Result(column = "dname",property ="dname"),
            @Result(column = "city",property ="city")
    })
    @SelectProvider(type = empSQL.class,method = "queryBy")
    public List<EmpDept> queryEmpDeptBy(Emp emp);


}
