package com.ag.dto;

public class Student {
    int sid;
    String sname;
    int srollno;

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public int getSrollno() {
        return srollno;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSrollno(int srollno) {
        this.srollno = srollno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", srollno=" + srollno +
                '}';
    }
}
