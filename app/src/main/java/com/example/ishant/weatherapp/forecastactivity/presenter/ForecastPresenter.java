package com.example.ishant.weatherapp.forecastactivity.presenter;

import android.util.Log;

import com.example.ishant.weatherapp.data.ForecastResponse;
import com.example.ishant.weatherapp.forecastactivity.view.ForecastActivity;
import com.google.gson.Gson;

import javax.inject.Inject;

public class ForecastPresenter implements ForecastPresenterContract {

    private static final String TAG = ForecastPresenter.class.getSimpleName();
    public ForecastActivity view;

    @Inject
    public ForecastPresenter()
    {

    }

    public void setView(ForecastActivity view)
    {
        this.view=view;
    }

    @Override
    public void Log(ForecastResponse response) {
        Gson gson = new Gson();

        Log.d(TAG,gson.toJson(response));
    }
}
