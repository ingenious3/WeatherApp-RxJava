package com.example.ishant.weatherapp.utils;

import android.text.format.DateFormat;

import com.example.ishant.weatherapp.data.ForecastDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DataFormattingUtils {

    public static ForecastDay DataFormat(ForecastDay data) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(data.getDate());
            data.setDate(String.valueOf(DateFormat.format("EEEE", date)));

            data.getDay().setAvgtemp_c(String.valueOf((int)Double.parseDouble(data.getDay().getAvgtemp_c())));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
