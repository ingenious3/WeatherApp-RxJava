package com.example.ishant.weatherapp;

import com.example.ishant.weatherapp.data.ForecastResponse;
import com.example.ishant.weatherapp.splashactivity.presenter.SplashPresenter;
import com.example.ishant.weatherapp.splashactivity.view.SplashActivity;
import com.example.ishant.weatherapp.utils.ApiCall;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SplashTest {

    @Mock
    public ApiCall apiCall;

    public SplashPresenter presenter;

    @Mock
    public SplashActivity activity;


    @Before
    public void SetUp() {
        presenter = new SplashPresenter(apiCall);
        presenter.setView(activity);

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });
        RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
    }

    @Test
    public void dataFetchTestError() {

        when(apiCall.getForecast(anyString(),anyString(),anyString())).thenReturn(Observable.<ForecastResponse>error(new IOException()));

        presenter.fetchData();
        verify(activity).showLoader();
        verify(activity).showError();
        verify(activity).dataFetched(null, true);

    }

    @Test
    public void dataFetchTestSuccess() {

       ForecastResponse forecastResponse = new ForecastResponse();
        when(apiCall.getForecast(anyString(),anyString(),anyString())).thenReturn(Observable.just(forecastResponse));

        presenter.fetchData();
        verify(activity).showLoader();
        verify(activity).dataFetched(forecastResponse, false);


    }

    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.reset();
    }
}

