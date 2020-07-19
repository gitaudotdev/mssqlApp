package com.kingshark.mssqlapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kingshark.mssqlapp.Models.Attendance;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;

public class ViewHolder extends RecyclerView.Adapter<ViewHolder.homeViewHolder> {

    Context context;
    ResultSet resultSet;
    List<Attendance> attendanceList;

    public ViewHolder(Context context, List<Attendance> attendanceList) {
        this.context = context;
        this.attendanceList = attendanceList;
    }

    @NonNull
    @Override
    public homeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.employee_list_item,parent,false);
        return new homeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull homeViewHolder holder, int position) {

        holder.status.setText(attendanceList.get(position).getAttendance());
        holder.txtName.setText(attendanceList.get(position).getName());
        holder.jobgroup.setText(attendanceList.get(position).getJobGroup());

        long date = System.currentTimeMillis();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY, h:mm a");
        String dateString = dateFormat.format(attendanceList.get(position).getDate());
        holder.date.setText(dateString);


    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    public class homeViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,date,jobgroup,status;

        public homeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.employee_name);
            date = itemView.findViewById(R.id.datetv);
            jobgroup = itemView.findViewById(R.id.jobgroup);
            status = itemView.findViewById(R.id.status);
        }
    }
}
