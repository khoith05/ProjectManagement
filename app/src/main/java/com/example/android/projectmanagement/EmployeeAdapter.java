package com.example.android.projectmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.projectmanagement.database.EmployeeSQL;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    private Context context;
    private List<EmployeeSQL> employeeSQLList;
    private EmployeeItemClickListener employeeItemClickListener;

    public EmployeeAdapter(Context context,List<EmployeeSQL> employeeSQLList){
        this.context=context;
        this.employeeSQLList=employeeSQLList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final EmployeeSQL employeeSQL=employeeSQLList.get(position);

        holder.name.setText(employeeSQL.name);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,EmployeeInfo.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("data",employeeSQL);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
//        holder.img.setImageBitma;
    }

    @Override
    public int getItemCount() {
        return employeeSQLList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView img;
        public RelativeLayout relativeLayout;
        public MyViewHolder(View view){
            super(view);
            name=view.findViewById(R.id.EmployeeListName);
            img=view.findViewById(R.id.EmployeeListAvarta);
            relativeLayout=view.findViewById(R.id.employeeLayout);
        }
    }

}
