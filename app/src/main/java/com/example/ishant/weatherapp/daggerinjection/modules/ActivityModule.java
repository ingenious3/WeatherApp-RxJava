package com.example.ishant.weatherapp.daggerinjection.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.ishant.weatherapp.daggerinjection.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context context() {
        return activity;
    }

    @Provides
    AppCompatActivity activity() {
        return activity;
    }

}
