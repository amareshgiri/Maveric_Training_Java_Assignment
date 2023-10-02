package com.ag.dto;

public class Customer {
       int cid;
       String cname;

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public void setSid(int id) {
        this.cid = id;
    }

    public void setSname(String name) {
        this.cname = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + cid +
                ", name='" + cname + '\'' +
                '}';
    }
}
