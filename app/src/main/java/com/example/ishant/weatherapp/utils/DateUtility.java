package com.example.ishant.weatherapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateUtility {

    public static String DateFormating(String s) {
        String newstring = "";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(s);
            newstring = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newstring;
    }
}
