package com.kingshark.mssqlapp;

import com.kingshark.mssqlapp.Models.Attendance;
import com.kingshark.mssqlapp.Models.Job;
import com.kingshark.mssqlapp.Models.Site;
import com.kingshark.mssqlapp.Models.Worker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<Job> getJob(){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection conn = ConnectionClass.Conn();

        List<Job> result = new ArrayList<>();
        try {
            String querystmt = "SELECT * FROM job";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(querystmt);
            while (rs.next()){
                result.add(new Job(rs.getString("name"),
                        rs.getFloat("pay")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public List<Site> getSites(){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = ConnectionClass.Conn();

        List<Site> site = new ArrayList<>();;

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM site";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                site.add(new Site(resultSet.getString("name"),
                        resultSet.getString("status")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return  site;
    }

//    public  List<Attendance> getAttendances(){
//        ConnectionClass connectionClass = new ConnectionClass();
//        Connection connection = ConnectionClass.Conn();
//
//        List<Attendance> attendanceList = new ArrayList<>();
//
//        try {
//            String querystmt = "SELECT * FROM test_table";
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(querystmt);
//            while (rs.next()){
//                attendanceList.add(new Attendance(rs.getString("EmployeeName"),
//                        rs.getString("JobGroup"),
//                        rs.getString("Attendance"),
//                        rs.getTimestamp("Date")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return  attendanceList;
//    }

    public List<Worker> getWorkers(){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection conn = ConnectionClass.Conn();
        List<Worker> result = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM worker";
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){
                result.add(new Worker(resultSet.getString("jid"),
                        resultSet.getString("sid"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getInt("idno"),
                        resultSet.getString("statue"),
                        resultSet.getFloat("pay")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
