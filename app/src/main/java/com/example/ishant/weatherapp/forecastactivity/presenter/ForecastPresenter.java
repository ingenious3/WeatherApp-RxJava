package com.example.ishant.weatherapp.forecastactivity.presenter;

import com.example.ishant.weatherapp.forecastactivity.view.ForecastActivity;

import javax.inject.Inject;

public class ForecastPresenter implements ForecastPresenterContract {

    public ForecastActivity view;

    @Inject
    public ForecastPresenter()
    {

    }

    public void setView(ForecastActivity view)
    {
        this.view=view;
    }
}
