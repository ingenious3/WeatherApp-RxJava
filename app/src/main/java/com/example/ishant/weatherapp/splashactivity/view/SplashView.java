package com.example.ishant.weatherapp.splashactivity.view;

import com.example.ishant.weatherapp.data.ForecastResponse;

public interface SplashView {

    void showError();

    void showLoader();

    void dataFetched(ForecastResponse data, Boolean isErrorFound);


}
