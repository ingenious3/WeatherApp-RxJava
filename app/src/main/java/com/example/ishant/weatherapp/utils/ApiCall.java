package com.example.ishant.weatherapp.utils;

import com.example.ishant.weatherapp.data.ForecastResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiCall {
    String FORECAST = "forecast.json";

    @Headers({"Content-Type: application/json"})
    @GET(FORECAST)
    Observable<ForecastResponse> getForecast(@Query("key") String key, @Query("q") String q, @Query("days") String days);
}
