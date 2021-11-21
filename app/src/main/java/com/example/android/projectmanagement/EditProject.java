package com.example.android.projectmanagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.projectmanagement.database.DatabaseHelper;
import com.example.android.projectmanagement.database.EmployeeSQL;
import com.example.android.projectmanagement.database.ProjectSQL;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class EditProject extends AppCompatActivity {
    boolean edit;
    String title="Chỉnh sửa nhân viên";
    ProjectSQL employeeSQL;
    public static final int PICKFILE_RESULT_CODE=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);

        Bundle extras= getIntent().getExtras();
        if (extras != null){
            this.edit=extras.getBoolean("edit");
        }
        ImageView back= (ImageView) findViewById(R.id.crossProject);
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
        ImageView check=(ImageView) findViewById(R.id.checkProject);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextInputEditText textInputEditText;

                textInputEditText=(TextInputEditText) findViewById(R.id.NameProject);
                String name=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.DesProject);
                String phone=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.StartProject);
                String email=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.EndProject);
                String job=textInputEditText.getText().toString();
                textInputEditText=(TextInputEditText) findViewById(R.id.StateProject);
                String address=textInputEditText.getText().toString();

                if (edit){
                    employeeSQL.name=name;
                    employeeSQL.description=phone;
                    employeeSQL.date_start=email;
                    Log.d("email",email);
                    employeeSQL.date_end=job;
                    employeeSQL.state=address;
                    databaseHelper.updateProject(employeeSQL);
                    Intent intent= new Intent();
                    intent.putExtra("success",true);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }else{
                    databaseHelper.insertProject(name,phone,email,job,address);
                    Intent intent= new Intent();
                    intent.putExtra("success",true);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }


            }
        });
        if (this.edit){
            Bundle bundle= getIntent().getExtras();
            if (bundle == null){
                return;
            }
            employeeSQL=(ProjectSQL) bundle.get("data");
            TextInputEditText textInputEditText;

            textInputEditText=(TextInputEditText) findViewById(R.id.NameProject);
            textInputEditText.setText(employeeSQL.name);
            textInputEditText=(TextInputEditText) findViewById(R.id.DesProject);
            textInputEditText.setText(employeeSQL.description);
            textInputEditText=(TextInputEditText) findViewById(R.id.StartProject);
            textInputEditText.setText(employeeSQL.date_start);
            textInputEditText=(TextInputEditText) findViewById(R.id.EndProject);
            textInputEditText.setText(employeeSQL.date_end);
            textInputEditText=(TextInputEditText) findViewById(R.id.StateProject);
            textInputEditText.setText(employeeSQL.state);


            this.title="Chỉnh sửa nhân viên";
        }else{
            this.title="Thêm nhân viên";
        }

        TextView textView= (TextView) findViewById(R.id.EditProjectTitle);
        textView.setText(this.title);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode==PICKFILE_RESULT_CODE){
            if(resultCode== Activity.RESULT_OK){
//                Uri uri=data.getData();
//                try{
//                    InputStream imageStream = getContentResolver().openInputStream(uri);
//                    Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
//                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                    bitmap.compress(Bitmap.CompressFormat.PNG,0,byteArrayOutputStream);
//                    Eimage=byteArrayOutputStream.toByteArray();
//                    imageView.setImageBitmap(bitmap);
//                } catch (FileNotFoundException e){
//                    e.printStackTrace();
//                }




            }
        }
    }
}