package com.telusko.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee1 {

    @Id
    private Integer eid;
    private String ename;

//    this transient annotation is used to ignore the field in the database
    @Transient
    private String ecity;
    private Integer eage;


    public Employee1() {
        System.out.println("Zero-args constructor called");
    }

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

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getEcity() {
        return ecity;
    }

    public void setEcity(String ecity) {
        this.ecity = ecity;
    }


    @Override
    public String toString() {
        return "Employee1{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", ecity='" + ecity + '\'' +
                ", eage=" + eage +
                '}';
    }
}
