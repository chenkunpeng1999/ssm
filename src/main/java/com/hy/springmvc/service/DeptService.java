package com.hy.springmvc.service;

import com.hy.springmvc.mapper.deptMapper;
import com.hy.springmvc.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private deptMapper deptMapper;

    /*public List<Dept> queryEmp(Dept dept){
       return deptMapper.queryDept(dept);
    };*/

}
