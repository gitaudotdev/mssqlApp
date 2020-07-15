package com.kingshark.mssqlapp;

import android.os.StrictMode;
import android.util.Log;

import net.sourceforge.jtds.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    public static Connection Conn(){
        String username = "test";
        String password ="root";
        //String port ="1433";
        String _class = "net.sourceforge.jtds.jdbc.Driver";
        String ip = "192.168.0.105";
        String db = "dbTest";
        String url = "jdbc:jtds:sqlserver://"+ip+"/"+db;

        Connection connection = null;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try{
            Class.forName(_class);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.e("CLASS ERROR", e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("SQL ERROR", e.getMessage());
        }
        return connection;
    }




}
