package com.example.ishant.weatherapp.daggerinjection.component;

import com.example.ishant.weatherapp.WeatherApplication;
import com.example.ishant.weatherapp.daggerinjection.modules.ApiModule;
import com.example.ishant.weatherapp.daggerinjection.scope.ApplicationScope;
import com.example.ishant.weatherapp.utils.ApiCall;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApiModule.class})
public interface ApplicationComponent {

    void inject(WeatherApplication applicationClass);

    ApiCall getApiCall();


}
