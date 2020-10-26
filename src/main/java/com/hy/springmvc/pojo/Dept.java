package com.hy.springmvc.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName(value = "dept")
public class Dept {

    private Integer did;
    private String dname;
    private String city;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
