package com.example.ishant.weatherapp.splashactivity.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ishant.weatherapp.BaseActivity;
import com.example.ishant.weatherapp.R;
import com.example.ishant.weatherapp.data.ForecastResponse;
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
        binding.setClickEvent(this);

        presenter.fetchData();
    }


    @Override
    public void showError() {
        binding.imgvProgress.setVisibility(View.GONE);
        binding.errorTextview.setVisibility(View.VISIBLE);
        binding.retryButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoader() {
        binding.imgvProgress.setVisibility(View.VISIBLE);
        binding.errorTextview.setVisibility(View.GONE);
        binding.retryButton.setVisibility(View.GONE);
    }

    @Override
    public void dataFetched(ForecastResponse data, Boolean isErrorFound) {
        if (data != null && !isErrorFound) {
            Intent i = new Intent(this, ForecastActivity.class);
            i.putExtra("data",data);
            startActivity(i);
            finish();
        } else
            Log.v(TAG + "datafetch", "something went wrong");
    }



    public void retryButtonClick(View v) {
        presenter.fetchData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.getDisposable().clear();
    }
}
