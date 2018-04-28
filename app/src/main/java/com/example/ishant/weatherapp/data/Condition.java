package com.example.ishant.weatherapp.data;

import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("code")
    private Integer code;
    @SerializedName("text")
    private String text;
    @SerializedName("icon")
    private String icon;

    public Condition() {
        code = 1;
        text = "";
        icon = "";
    }

    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }
}
