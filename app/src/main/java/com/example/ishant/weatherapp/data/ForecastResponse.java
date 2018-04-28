package com.example.ishant.weatherapp.data;

import com.google.gson.annotations.SerializedName;

public class ForecastResponse{

    @SerializedName("location")
    private Location location;
    @SerializedName("current")
    private Current current;
    @SerializedName("forecast")
    private Forecast forecast;

    public ForecastResponse() {
        location = new Location();
        current = new Current();
        forecast = new Forecast();
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }
}
