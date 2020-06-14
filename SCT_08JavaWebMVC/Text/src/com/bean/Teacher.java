package com.bean;

public class Teacher {
    private int tid;
    private String tname;
    private int sex;
    private String email;
    private String phone_number;
    private String password;

    public Teacher(int tid, String tname, int sex, String email, String phone_number, String password) {
        this.tid = tid;
        this.tname = tname;
        this.sex = sex;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }

    public Teacher() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
