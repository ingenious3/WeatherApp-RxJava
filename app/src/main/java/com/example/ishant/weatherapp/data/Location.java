package com.example.ishant.weatherapp.data;

import com.google.gson.annotations.SerializedName;

public class Location{

    @SerializedName("name")
    private String name;

    public Location() {
        name = "";
    }

    public String getName() {
        return name;
    }
}
