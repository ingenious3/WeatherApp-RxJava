package com.example.ishant.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ForecastResponse implements Parcelable {
    private Forecast forecast;

    private Location location;

    private Current current;

    public ForecastResponse() {
    }

    protected ForecastResponse(Parcel in) {
        forecast = in.readParcelable(Forecast.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        current = in.readParcelable(Current.class.getClassLoader());
    }

    public static final Creator<ForecastResponse> CREATOR = new Creator<ForecastResponse>() {
        @Override
        public ForecastResponse createFromParcel(Parcel in) {
            return new ForecastResponse(in);
        }

        @Override
        public ForecastResponse[] newArray(int size) {
            return new ForecastResponse[size];
        }
    };

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(forecast, flags);
        dest.writeParcelable(location, flags);
        dest.writeParcelable(current, flags);
    }
}
