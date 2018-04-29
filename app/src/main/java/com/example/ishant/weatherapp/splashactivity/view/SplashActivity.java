package com.example.ishant.weatherapp.splashactivity.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ishant.weatherapp.R;

public class SplashActivity extends AppCompatActivity implements SplashView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void launchForecastActivity() {

    }

    @Override
    public void showErrorMessage() {

    }
}
