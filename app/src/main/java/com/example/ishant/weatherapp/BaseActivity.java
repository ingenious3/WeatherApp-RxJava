package com.example.ishant.weatherapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ishant.weatherapp.daggerinjection.component.ActivityComponent;
import com.example.ishant.weatherapp.daggerinjection.component.DaggerActivityComponent;
import com.example.ishant.weatherapp.daggerinjection.modules.ActivityModule;


public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent =  DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(WeatherApplication.get(this).getApplicationComponent())
                .build();

    }

    public ActivityComponent getActivityComponent()
    {
        return activityComponent;
    }
}
