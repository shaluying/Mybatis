package com.shaluy.mybatis.pojo;

/**
 * 学生信息
 */
public class Student { //Student 是多的一方
    private Integer sid;
    private String sname;
    private Clazz clazz; //Clazz 是一的一方

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student() {
    }

    public Student(Integer sid, String name) {
        this.sid = sid;
        this.sname = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

}
