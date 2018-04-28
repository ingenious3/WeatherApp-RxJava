package com.example.ishant.weatherapp;


import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApplication extends Application {

    private static final String BASE_URL = "http://api.apixu.com/v1/";

    private Retrofit retrofit;

    private static WeatherApplication weatherApplication;

    public static final String TAG = WeatherApplication.class.getSimpleName();

    public synchronized static WeatherApplication getInstance() {
        if (weatherApplication == null) {
            weatherApplication = new WeatherApplication();
        }
        return weatherApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        weatherApplication = this;
    }


    public Retrofit getRetrofit() {
        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }




}
