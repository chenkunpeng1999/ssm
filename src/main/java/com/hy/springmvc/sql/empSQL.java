package com.hy.springmvc.sql;

import com.hy.springmvc.pojo.Emp;
import com.hy.springmvc.pojo.EmpDept;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

public class empSQL {
    @Autowired
    private Emp emp;

    public String query(@Param("em") Emp emp){
        StringBuffer sql = null;
        if(emp!=null&&!emp.equals("")){

            sql = new StringBuffer("select * from emp e left join dept d on e.did=d.did where 1=1");
            if(emp.getEname() != null&&!"".equals(emp.getEname())){
                sql.append(" and ename like '%"+emp.getEname()+"%'");
            }
            if (emp.getSex() != null&&!"".equals(emp.getSex())){
                sql.append(" and sex='"+emp.getSex()+"'");
            }
            if (emp.getDid() != null&&!"".equals(emp.getDid())){
                sql.append(" and e.did="+emp.getDid());
            }
        }
        return sql.toString();
    }

    public String queryBy(Emp emp){
        StringBuffer sql = null;
        if(emp!=null&&!emp.equals("")){

            sql = new StringBuffer("select * from emp e left join dept d on e.did=d.did where 1=1");
            if(emp.getEid() != null){
                sql.append(" and eid=#{eid}");
            }
            if(emp.getEname() != null){
                sql.append(" and ename like '%"+emp.getEname()+"%'");
            }
            if (emp.getDid() != null){
                sql.append(" and e.did=#{did}");
            }
        }
        return sql.toString();
    }

}
