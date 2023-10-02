package com.ag.dto;

public class Product {
    private long pid;

    private double pprice;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pprice=" + pprice +
                '}';
    }
}
