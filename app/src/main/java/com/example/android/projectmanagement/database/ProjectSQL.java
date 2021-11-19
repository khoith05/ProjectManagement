package com.example.android.projectmanagement.database;

import java.io.Serializable;

public class ProjectSQL implements Serializable {
    public static final String TABLE_NAME="project";
    public static final String COLUMN_ID ="ID";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_DES="Description";
    public static final String COLUMN_START="Date_start";
    public static final String COLUMN_END="Date_end";
    public static final String COLUMN_STATE="state";

    public long id;
    public String name;
    public String description;
    public String date_start;
    public String date_end;
    public String state;

    public static final String CREATE_TABLE=
            "CREATE TABLE "+ TABLE_NAME+" ("+
                    COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    COLUMN_NAME +" TEXT,"+
                    COLUMN_DES+" TEXT,"+
                    COLUMN_START+" TEXT,"+
                    COLUMN_END+" TEXT,"+
                    COLUMN_STATE+" BLOB )";
    public ProjectSQL(){
    }
    public ProjectSQL(long id, String name, String phone, String email, String job, String address){
        this.id=id;
        this.name=name;
        this.description=phone;
        this.date_start=email;
        this.date_end=job;
        this.state=address;
    }
    public long getID(){
        return this.id;

    }
    public ProjectSQL getEmployeeInfo(){
        return this;
    }

}
