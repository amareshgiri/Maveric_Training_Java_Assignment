package com.ag.dto;

public class FeedBack {
    int Fid;
    String Fdescription;
    Customer customer;

    public int getFid() {
        return Fid;
    }

    public String getFDescription() {
        return Fdescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setFid(int id) {
        this.Fid = id;
    }

    public void setFDescription(String description) {
        this.Fdescription = description;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + Fid +
                ", description='" + Fdescription + '\'' +
                ", customer=" + customer +
                '}';
    }
}
