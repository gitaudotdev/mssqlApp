package com.kingshark.mssqlapp;

public class Attendance {
    String name,jobGroup,attendance;


    public Attendance() {
    }

    public Attendance(String name, String jobGroup, String attendance) {
        this.name = name;
        this.jobGroup = jobGroup;
       this.attendance = attendance;
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


}
