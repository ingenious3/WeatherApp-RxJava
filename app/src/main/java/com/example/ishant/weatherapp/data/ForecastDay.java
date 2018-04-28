package com.example.ishant.weatherapp.data;

import com.google.gson.annotations.SerializedName;

public class ForecastDay {

    @SerializedName("date")
    private String date;
    @SerializedName("day")
    private Day day;

    public ForecastDay() {
        date = "";
        day = new Day();
    }

    public String getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }
}
