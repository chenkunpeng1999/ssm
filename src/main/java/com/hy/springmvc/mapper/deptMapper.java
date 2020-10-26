package com.hy.springmvc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.springmvc.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface deptMapper extends BaseMapper<Dept> {

    /*@SelectProvider(type = deptSQL.class,method = "query")
    public List<Dept> queryDept(Dept dept);*/
}
