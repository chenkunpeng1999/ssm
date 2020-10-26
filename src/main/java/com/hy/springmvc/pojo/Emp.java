package com.hy.springmvc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "emp")
public class Emp {

    @TableId(value = "eid",type = IdType.AUTO)
    private Integer eid;
    @TableField(value = "ename")
    private String ename;
    @TableField(value = "did")
    private Integer did;
    @TableField(value = "sex")
    private String sex;
    @TableField(value = "birthday")
    private String birthday;
    @TableField(value = "sal")
    private double sal;


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }


    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", did=" + did +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sal=" + sal +
                '}';
    }
}
