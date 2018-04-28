package com.example.ishant.weatherapp.data;

import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("mintemp_c")
    private Double mintemp_c;
    @SerializedName("maxtemp_c")
    private Double maxtemp_c;
    @SerializedName("condition")
    private Condition condition;

    public Day() {
        mintemp_c = 0.0;
        maxtemp_c = 0.0;
        condition = new Condition();
    }

    public Double getMintemp_c() {
        return mintemp_c;
    }

    public Double getMaxtemp_c() {
        return maxtemp_c;
    }

    public Condition getCondition() {
        return condition;
    }
}
