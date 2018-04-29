package com.example.ishant.weatherapp.utils;

import com.example.ishant.weatherapp.data.ForecastDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DataFormattingUtility {

    public static ForecastDay DataFormat(ForecastDay data) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(data.getDate());
            String newstring = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(date);


            Date curretnDate = new Date();
            Long time = curretnDate.getTime() + 24 * 60 * 60 * 1000;
            Date tomorrow = new Date(time);

            String currentDate = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(curretnDate);
            String tomorrowString = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(tomorrow);


            if (newstring.equalsIgnoreCase(currentDate))
                data.setDate("Today");
            else if (newstring.equalsIgnoreCase(tomorrowString))
                data.setDate("Tomorrow");
            else
                data.setDate(newstring);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
