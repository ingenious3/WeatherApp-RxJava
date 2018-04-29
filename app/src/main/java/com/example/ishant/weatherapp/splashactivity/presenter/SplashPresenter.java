package com.example.ishant.weatherapp.splashactivity.presenter;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.ishant.weatherapp.splashactivity.view.SplashActivity;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter implements SplashPresenterContract {

    public SplashActivity view;
    private CompositeDisposable compositeDisposable;

    @Inject
    public SplashPresenter() {
        compositeDisposable = new CompositeDisposable();

    }

    public void setView(SplashActivity view) {
        this.view = view;
    }

    @Override
    public void wait3seconds() {
        Thread background = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    sleep(1 * 3000);
                   view.launchForecastActivity();
                } catch (Exception e) {

                }
            }
        };
        background.start();

    }

    @Override
    public CompositeDisposable getDisposable() {
        return compositeDisposable;
    }
}
