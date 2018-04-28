package com.example.ishant.weatherapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Forecast {

    @SerializedName("forecastday")
    private ArrayList<ForecastDay> forecastday;

    public Forecast() {
        forecastday = new ArrayList<>();
    }

    public ArrayList<ForecastDay> getForecastday() {
        return forecastday;
    }
}
