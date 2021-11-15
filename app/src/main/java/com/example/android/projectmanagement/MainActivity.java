package com.example.android.projectmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;

import androidx.annotation.NonNull;

import java.io.*;

public class MainActivity extends AppCompatActivity {
    Project project= new Project();
    User user = new User();
    Employee employee = new Employee();
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView= findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, user).commit();
                        return true;

                    case R.id.project:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, project).commit();
                        return true;

                    case R.id.employee:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, employee).commit();
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.user);


    }


}