package com.example.ishant.weatherapp.splashactivity.presenter;

import com.example.ishant.weatherapp.data.ForecastResponse;
import com.example.ishant.weatherapp.splashactivity.view.SplashActivity;
import com.example.ishant.weatherapp.utils.ApiCall;
import com.example.ishant.weatherapp.utils.ApiKey;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter implements SplashPresenterContract {

    public SplashActivity view;
    private ApiCall apiCall;
    private CompositeDisposable compositeDisposable;

    @Inject
    public SplashPresenter(ApiCall apiCall){
        this.apiCall = apiCall;
        compositeDisposable = new CompositeDisposable();
    }

    public void setView(SplashActivity view) {
        this.view = view;
    }

    @Override
    public CompositeDisposable getDisposable() {
        return compositeDisposable;
    }

    @Override
    public void fetchData() {
        view.showLoader();
        compositeDisposable.add(apiCall.getForecast(ApiKey.API_KEY.getValue(), ApiKey.PLACE.getValue(), ApiKey.DAYS.getValue())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<ForecastResponse>() {
                    @Override
                    public void onNext(ForecastResponse weather) {
                        if (view != null) {
                            view.dataFetched(weather, false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.showError();
                            view.dataFetched(null, true);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }

                }));
    }

}
