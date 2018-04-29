package com.example.ishant.weatherapp.splashactivity.presenter;

import io.reactivex.disposables.CompositeDisposable;

public interface SplashPresenterContract {

  //  void fetchData();
    void wait3seconds();
    CompositeDisposable getDisposable();

}
