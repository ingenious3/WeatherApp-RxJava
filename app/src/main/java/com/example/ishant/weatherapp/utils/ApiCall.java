package com.example.ishant.weatherapp.utils;

import com.example.ishant.weatherapp.data.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public class ApiCall {
    public String FORECAST = "forecast.json";

    @Headers({"Content-Type: application/json"})
    @GET(FORECAST)
    Call<ForecastResponse> getForecast(@Query("key") String key, @Query("q") String q, @Query("days") String days);
}
