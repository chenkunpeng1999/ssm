package com.hy.springmvc.pojo;

public class EmpDept {

    private Integer eid;
    private String ename;
    private Integer did;
    private String sex;
    private String birthday;
    private double sal;
    private String dname;
    private String city;

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
        return "EmpDept{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", did=" + did +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sal=" + sal +
                ", dname='" + dname + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
