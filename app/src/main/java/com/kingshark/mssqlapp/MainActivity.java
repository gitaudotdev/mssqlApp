package com.kingshark.mssqlapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    RecyclerView attendance;
    FloatingActionButton fab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        attendance = findViewById(R.id.attendance_recycler);
        fab = findViewById(R.id.edtFab);

        attendance.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        attendance.setLayoutManager(layoutManager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAttendanceDialog();
            }
        });
    }

    private void showAttendanceDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Enter Employee name and check attendance");

        View itemView = getLayoutInflater().inflate(R.layout.attendance_layout,null);
        Button btn_save = itemView.findViewById(R.id.btn_save);
        final TextView txt_date = itemView.findViewById(R.id.date_text);
        final TextInputEditText edtName = itemView.findViewById(R.id.edt_name);
        final TextInputEditText edt_job = itemView.findViewById(R.id.edt_jobGroup);
        final MaterialCheckBox checkBox = itemView.findViewById(R.id.mcheckbox);

        long date = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY, h:mm a");
        String dateString = dateFormat.format(date);
        txt_date.setText(dateString);

        String check = "";
        if (checkBox.isChecked()){
            check += "Present";
        }else
            check += "Absent";


        final String finalCheck = check;

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtName.getText().toString();
                String job = edt_job.getText().toString();

                ConnectionClass connectionClass = new ConnectionClass();
                Connection connection = ConnectionClass.Conn();

                try {

                    String query = "INSERT into test_table (EmployeeName,JobGroup,Attendance) values ('name','job','finalCheck')";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.executeUpdate();
                    statement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                finish();

            }

        });

        dialog.setView(itemView);
        dialog.show();


    }


}