package com.example.ishant.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Forecast implements Parcelable
{
    private List<ForecastDay> forecastday;

    protected Forecast(Parcel in) {
        forecastday = in.createTypedArrayList(ForecastDay.CREATOR);
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

    public List<ForecastDay> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<ForecastDay> forecastday) {
        this.forecastday = forecastday;
    }

    public static Creator<Forecast> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(forecastday);
    }
}