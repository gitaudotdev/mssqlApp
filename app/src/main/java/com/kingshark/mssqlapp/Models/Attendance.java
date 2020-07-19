package com.kingshark.mssqlapp.Models;

import java.sql.Timestamp;

public class Attendance {
    String name,jobGroup,attendance;
    Timestamp date;


    public Attendance() {
    }


    public Attendance(String name, String jobGroup, String attendance, Timestamp date) {
        this.name = name;
        this.jobGroup = jobGroup;
        this.attendance = attendance;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }


    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
