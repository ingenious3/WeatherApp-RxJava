package com.example.ishant.weatherapp.splashactivity.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.ishant.weatherapp.BaseActivity;
import com.example.ishant.weatherapp.R;
import com.example.ishant.weatherapp.databinding.ActivitySplashBinding;
import com.example.ishant.weatherapp.forecastactivity.view.ForecastActivity;
import com.example.ishant.weatherapp.splashactivity.presenter.SplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashView {

    private static final String TAG = SplashActivity.class.getSimpleName();

    ActivitySplashBinding binding;

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        presenter.setView(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        presenter.wait3seconds();
    }


    @Override
    public void launchForecastActivity() {
        Intent i = new Intent(this, ForecastActivity.class);
//        i.putExtra("data",data);
        startActivity(i);
        finish();
    }
}
