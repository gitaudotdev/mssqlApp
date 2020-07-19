package com.kingshark.mssqlapp.Models;

public class Worker {
    String jobId,siteId,name,phoneNumber,status;
    int idNo;
    float pay;

    public Worker() {
    }

    public Worker(String jobId, String siteId, String name, String phoneNumber, int idNo, String status, float pay) {
        this.jobId = jobId;
        this.siteId = siteId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.idNo = idNo;
        this.status = status;
        this.pay = pay;
    }


    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }
}
