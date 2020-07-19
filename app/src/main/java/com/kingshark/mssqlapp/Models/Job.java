package com.kingshark.mssqlapp.Models;

public class Job {
    String name;
    float pay;

    public Job() {
    }

    public Job(String name, float pay) {
        this.name = name;
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }
}
