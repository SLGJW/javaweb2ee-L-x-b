package com.bean;

public class Student {
    private int sid;
    private String sname;
    private String sclass;
    private String phone_number;
    private String password;
    private int age;
    private int sex;

    public Student() {
    }

    public Student(int sid, String sname, String sclass, String phone_number, String password, int age, int sex) {
        this.sid = sid;
        this.sname = sname;
        this.sclass = sclass;
        this.phone_number = phone_number;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(){
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

}
