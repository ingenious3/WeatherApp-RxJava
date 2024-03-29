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
import com.example.ishant.weatherapp.utils.UiAnimationUtils;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashView {

    private static final String TAG = SplashActivity.class.getSimpleName();

    @Inject
    SplashPresenter presenter;

    ActivitySplashBinding binding;

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
        binding.splashScreen.setBackgroundColor(getResources().getColor(R.color.theme_red));
        binding.imgvProgress.setVisibility(View.GONE);
        binding.errorTextview.setVisibility(View.VISIBLE);
        binding.retryButton.setVisibility(View.VISIBLE);
        UiAnimationUtils.stopAnimation(binding.imgvProgress);
    }

    @Override
    public void showLoader() {
        binding.splashScreen.setBackgroundColor(getResources().getColor(R.color.theme_background));
        binding.imgvProgress.setVisibility(View.VISIBLE);
        binding.errorTextview.setVisibility(View.GONE);
        binding.retryButton.setVisibility(View.GONE);
        UiAnimationUtils.rotate(binding.imgvProgress,this);
    }

    @Override
    public void dataFetched(ForecastResponse data, Boolean isErrorFound) {
        if (data != null && !isErrorFound) {
            Intent i = new Intent(this, ForecastActivity.class);
            i.putExtra("data",data);
            startActivity(i);
            finish();
        } else
            Log.d(TAG + "datafetch", "something went wrong");
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
