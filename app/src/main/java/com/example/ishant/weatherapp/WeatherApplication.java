package com.example.ishant.weatherapp;


import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.example.ishant.weatherapp.daggerinjection.component.ApplicationComponent;
import com.example.ishant.weatherapp.daggerinjection.component.DaggerApplicationComponent;
import com.example.ishant.weatherapp.daggerinjection.modules.ApiModule;

import retrofit2.Retrofit;

public class WeatherApplication extends Application {

    private static final String BASE_URL = "http://api.apixu.com/v1/";

    private Retrofit retrofit;

    private static WeatherApplication weatherApplication;
    ApplicationComponent applicationComponent;

    public static final String TAG = WeatherApplication.class.getSimpleName();

    public static WeatherApplication get(AppCompatActivity activity) {
        return (WeatherApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .apiModule(new ApiModule(BASE_URL))
                .build();
        applicationComponent.inject(this);
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }




}
