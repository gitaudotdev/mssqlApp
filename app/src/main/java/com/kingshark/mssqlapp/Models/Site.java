package com.kingshark.mssqlapp.Models;

public class Site {
    String name,status;

    public Site(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public Site() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
