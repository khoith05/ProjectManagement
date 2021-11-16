package com.example.android.projectmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.projectmanagement.database.EmployeeSQL;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    private Context context;
    private List<EmployeeSQL> employeeSQLList;

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
        EmployeeSQL employeeSQL=employeeSQLList.get(position);

        holder.name.setText(employeeSQL.name);
//        holder.img.setImageBitma;
    }

    @Override
    public int getItemCount() {
        return employeeSQLList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView img;
        public MyViewHolder(View view){
            super(view);
            name=view.findViewById(R.id.EmployeeListName);
            img=view.findViewById(R.id.EmployeeListAvarta);
        }
    }

}
