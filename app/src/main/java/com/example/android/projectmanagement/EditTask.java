package com.example.android.projectmanagement;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.android.projectmanagement.database.DatabaseHelper;
import com.example.android.projectmanagement.database.EmployeeSQL;
import com.example.android.projectmanagement.database.TaskSQL;
import com.google.android.material.chip.Chip;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


import java.text.ParseException;
import java.util.List;


public class EditTask extends AppCompatActivity {
    public boolean edit;
    public long projectid;
    public long taskid;
    public DatabaseHelper db;
    public TextInputEditText nameView;
    public TextInputEditText desView;
    public TextInputEditText startDate;
    public TextInputEditText endDate;
    public List<EmployeeSQL> employeeSQLList;
    public List<EmployeeSQL> chooseList;
    public List<EmployeeSQL> unchooseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        Bundle extras=getIntent().getExtras();
        if(extras==null){
            return;
        }
        edit=extras.getBoolean("edit");
        projectid=extras.getLong("projectid");
        Chip chip=findViewById(R.id.chipTask);
        TextInputLayout startLayout=findViewById(R.id.startDateTaskLayout);
        TextInputLayout endLayout= findViewById(R.id.endDateTaskLayout);
        nameView=findViewById(R.id.TaskNameinput);
        desView=findViewById(R.id.TaskDesciptionTaskEdit);
        startDate =findViewById(R.id.startDateTask);
        endDate=findViewById(R.id.endDateTask);
        startLayout.setStartIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
                materialDateBuilder.setTitleText("Chọn ngày bắt đầu");
                final MaterialDatePicker materialDatePicker = materialDateBuilder.build();
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                materialDatePicker.addOnPositiveButtonClickListener(
                        new MaterialPickerOnPositiveButtonClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onPositiveButtonClick(Object selection) {
                                try {
                                    String date =DateHelper.DateConvert(materialDatePicker.getHeaderText());
                                    startDate.setText(date );
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
            }
        });
        endLayout.setStartIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
                materialDateBuilder.setTitleText("Chọn ngày kết thúc");
                final MaterialDatePicker materialDatePicker = materialDateBuilder.build();
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                materialDatePicker.addOnPositiveButtonClickListener(
                        new MaterialPickerOnPositiveButtonClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onPositiveButtonClick(Object selection) {
                                try {
                                    String date =DateHelper.DateConvert(materialDatePicker.getHeaderText());
                                    endDate.setText( materialDatePicker.getHeaderText());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView=inflater.inflate(R.layout.add_employee_task,null);
                int width= LinearLayout.LayoutParams.WRAP_CONTENT;
                int height= LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable=true;
                final PopupWindow popupWindow=new PopupWindow(popupView,width,height,focusable);
                popupWindow.showAtLocation(v, Gravity.CENTER,0,0);




            }
        });
        if (edit){
            taskid=extras.getLong("taskid");
            TaskSQL taskSQL=db.getTask(taskid);
            nameView.setText(taskSQL.name);
            desView.setText(taskSQL.desciption);
            startDate.setText(taskSQL.start);
            startDate.setText(taskSQL.end);

        }else {

        }
    }
}