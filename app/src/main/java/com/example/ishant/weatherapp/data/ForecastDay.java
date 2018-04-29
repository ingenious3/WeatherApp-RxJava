package com.example.ishant.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ForecastDay implements Parcelable
{

    private Day day;

    private String date;

    private String date_epoch;

    protected ForecastDay(Parcel in) {
        day = in.readParcelable(Day.class.getClassLoader());
        date = in.readString();
        date_epoch = in.readString();
    }

    public static final Creator<ForecastDay> CREATOR = new Creator<ForecastDay>() {
        @Override
        public ForecastDay createFromParcel(Parcel in) {
            return new ForecastDay(in);
        }

        @Override
        public ForecastDay[] newArray(int size) {
            return new ForecastDay[size];
        }
    };

    public Day getDay ()
    {
        return day;
    }

    public void setDay (Day day)
    {
        this.day = day;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getDate_epoch ()
    {
        return date_epoch;
    }

    public void setDate_epoch (String date_epoch)
    {
        this.date_epoch = date_epoch;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeParcelable(day, flags);
        dest.writeString(date);
        dest.writeString(date_epoch);
    }
}
