package com.hy.springmvc.sql;

import com.hy.springmvc.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;

public class deptSQL {
    @Autowired
    private Dept dept;

    public String query(Dept dept){
        StringBuffer sql = new StringBuffer("select * from dept where 1=1 ");
        if(dept.getDid()!=null){
            sql.append(" and did=#{did}");
        }
        if(dept.getDname() != null){
            sql.append(" and dname=#{dname}");
        }
        if(dept.getCity() != null){
            sql.append(" and city=#{city}");
        }
        return sql.toString();
    }

}
