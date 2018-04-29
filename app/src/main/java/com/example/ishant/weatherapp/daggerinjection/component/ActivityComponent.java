package com.example.ishant.weatherapp.daggerinjection.component;

import android.content.Context;

import com.example.ishant.weatherapp.daggerinjection.modules.ActivityModule;
import com.example.ishant.weatherapp.daggerinjection.scope.ActivityContext;
import com.example.ishant.weatherapp.daggerinjection.scope.PerActivity;
import com.example.ishant.weatherapp.forecastactivity.view.ForecastActivity;
import com.example.ishant.weatherapp.splashactivity.view.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    @ActivityContext
    Context getContext();

    void inject(ForecastActivity mainActivity);
    void inject(SplashActivity splashScreenActivity);

}
