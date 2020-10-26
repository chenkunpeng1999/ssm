package com.hy.springmvc.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.hy.springmvc.mapper.deptMapper;
import com.hy.springmvc.mapper.empMapper;
import com.hy.springmvc.pojo.Dept;
import com.hy.springmvc.pojo.Emp;
import com.hy.springmvc.pojo.EmpDept;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmpService extends ServiceImpl<empMapper, Emp> {

    @Autowired
    private com.hy.springmvc.mapper.deptMapper deptMapper;

    @Autowired
    private empMapper empMapper;

    public List<Dept> queryDname(){
        return deptMapper.selectList(null);
    };

    public List<EmpDept> queryEmpDept(){
        return empMapper.queryEmpDept();
    };

    public IPage<EmpDept> querylist(Integer page,Integer limit, @Param("em")Emp emp){
        return empMapper.querylist(new Page<EmpDept>(page,limit),emp);
    }

    public EmpDept queryBy(Emp emp){
        return empMapper.queryBy(emp);
    }

    public void insertEmp(Emp emp){
        empMapper.insert(emp);
    };

    public void updateEmp(Emp emp){
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("ename",emp.getEname());
        wrapper.eq("did",emp.getDid());
        wrapper.eq("sex",emp.getSex());
        wrapper.eq("birthday",emp.getBirthday());
        wrapper.eq("sal",emp.getSal());
        empMapper.update(emp,wrapper);
    };

}
