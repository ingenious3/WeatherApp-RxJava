package com.example.ishant.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Forecast implements Parcelable
{
    private ForecastDay[] forecastday;

    protected Forecast(Parcel in) {
        forecastday = in.createTypedArray(ForecastDay.CREATOR);
    }

    public static final Creator<Forecast> CREATOR = new Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }

        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };

    public ForecastDay[] getForecastday ()
    {
        return forecastday;
    }

    public void setForecastday (ForecastDay[] forecastday)
    {
        this.forecastday = forecastday;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(forecastday, flags);
    }
}