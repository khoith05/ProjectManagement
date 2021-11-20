package com.example.android.projectmanagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static Date StringToDate(String dt) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        Date date=format.parse(dt);
        return date;
    }
    public static Date StringToDate2(String dt) throws ParseException {
        SimpleDateFormat formater=new SimpleDateFormat("MMM dd,yyyy");
        Date date=formater.parse(dt);

        return date;
    }
    public static String DateToString(Date date){
        return date.toString();
    }
    public static String DateConvert(String date) throws ParseException {
        SimpleDateFormat formater=new SimpleDateFormat("MMM dd,yyyy");
        Date before=formater.parse(date);
        SimpleDateFormat formater2=new SimpleDateFormat("dd/MM/yyyy");
        String Adate=formater2.format(before);
        return Adate;
    }

}
