package com.example.android.projectmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.projectmanagement.database.DatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

public class EditEmployee extends AppCompatActivity {
    boolean edit;
    String title="";
    String name="";
    String phone="";
    String email="";
    String job="";
    String address="";
    Double salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        Bundle extras= getIntent().getExtras();
        if (extras != null){
            this.edit=extras.getBoolean("edit");
        }
        ImageView back= (ImageView) findViewById(R.id.crossEmployee);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("success",false);
                setResult(3,intent);
                finish();
            }
        });
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        ImageView check=(ImageView) findViewById(R.id.checkEmployee);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextInputEditText textInputEditText;

                textInputEditText=(TextInputEditText) findViewById(R.id.EmployeeName);
                String name=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.EmployeePhone);
                String phone=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.EmployeeEmail);
                String email=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.EmployeeJob);
                String job=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.EmployeeAddress);
                String address=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.EmployeeSalary);
                String salary=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.EmployeeSalary);
                String img=textInputEditText.getText().toString();

                databaseHelper.insertEmployee(name,phone,email,job,address,salary,img.getBytes());
                Intent intent= new Intent();
                intent.putExtra("success",true);
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });
        if (this.edit){

        }else{
            this.title="Thêm nhân viên";
            TextView textView= (TextView) findViewById(R.id.EditEmployeeTitle);
            textView.setText(this.title);
        }
    }
}