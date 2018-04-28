package com.example.ishant.weatherapp.data;

import com.google.gson.annotations.SerializedName;

public class Current{

    @SerializedName("temp_c")
    private Double temp_c;

    public Current() {
        temp_c = 0.0;
    }

    public Double getTemp_c() {
        return temp_c;
    }
}
