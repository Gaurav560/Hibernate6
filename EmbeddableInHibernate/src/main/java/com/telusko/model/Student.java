package com.telusko.model;

import jakarta.persistence.*;

@Entity
@Table(name="StudentTable")
public class Student {


    @Id
    @Column(name="SID")
    private Integer sid;

    @Column(name="SNAME")
    private StudentName sName;

    @Column(name="SCITY")
    private String sCity;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public StudentName getsName() {
        return sName;
    }

    public void setsName(StudentName sName) {
        this.sName = sName;
    }


    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public Student() {
        System.out.println("Zero param constructor");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sName=" + sName +
                ", sCity='" + sCity + '\'' +
                '}';
    }
}
