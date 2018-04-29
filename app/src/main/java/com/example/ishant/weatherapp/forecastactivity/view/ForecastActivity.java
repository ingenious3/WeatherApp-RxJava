package com.example.ishant.weatherapp.forecastactivity.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.example.ishant.weatherapp.BaseActivity;
import com.example.ishant.weatherapp.R;
import com.example.ishant.weatherapp.data.ForecastResponse;
import com.example.ishant.weatherapp.databinding.ActivityForecastBinding;
import com.example.ishant.weatherapp.forecastactivity.adapter.ForecastAdapter;
import com.example.ishant.weatherapp.forecastactivity.presenter.ForecastPresenter;
import com.example.ishant.weatherapp.utils.UiAnimationUtils;

import javax.inject.Inject;

public class ForecastActivity extends BaseActivity implements ForecastView{

    private ActivityForecastBinding binding;
    private LinearLayoutManager layoutManager;
    private ForecastResponse forecastResponse;

    @Inject
    ForecastPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_forecast);
        getActivityComponent().inject(this);
        presenter.setView(this);
        showData();
    }

    public void showData(){
        Bundle data = getIntent().getExtras();
        if (data != null) {
            forecastResponse = (ForecastResponse) data.getParcelable("data");
        }
        binding.setData(forecastResponse);

        ForecastAdapter adapter = new ForecastAdapter(this, forecastResponse);
        binding.forecastList.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.forecastList.setLayoutManager(layoutManager);
        binding.forecastList.setItemAnimator(new DefaultItemAnimator());
        binding.forecastList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        UiAnimationUtils.slideUp(binding.scroll,this);

        presenter.Log(forecastResponse);
    }


}
