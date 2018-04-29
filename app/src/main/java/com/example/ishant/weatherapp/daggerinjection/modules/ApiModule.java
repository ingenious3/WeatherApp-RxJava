package com.example.ishant.weatherapp.daggerinjection.modules;

import com.example.ishant.weatherapp.daggerinjection.scope.ApplicationScope;
import com.example.ishant.weatherapp.utils.ApiCall;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module (includes = {NetworkModule.class})
public class ApiModule {

    String baseUrl;
    public ApiModule(String baseUrl)
    {
        this.baseUrl=baseUrl;
    }

    @Provides
    @ApplicationScope
    public ApiCall apiCalls(Retrofit retrofit)
    {
        return retrofit.create(ApiCall.class);
    }

    @Provides
    @ApplicationScope
    public Retrofit retrofitClient(OkHttpClient client)
    {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(baseUrl)
                .build();
    }


}
