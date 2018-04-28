package com.example.ishant.weatherapp.utils;

public enum ApiKey {

    API_KEY("87a7e4629aa6487f84a213853181704"),
    PLACE("Bangalore"),
    DAYS("5");

    private String value;

    ApiKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
