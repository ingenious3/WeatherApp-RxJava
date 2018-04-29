package com.example.ishant.weatherapp.data;


import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
    private String region;

    private String localtime;

    private String localtime_epoch;

    private String lon;

    private String tz_id;

    private String name;

    private String lat;

    private String country;

    protected Location(Parcel in) {
        region = in.readString();
        localtime = in.readString();
        localtime_epoch = in.readString();
        lon = in.readString();
        tz_id = in.readString();
        name = in.readString();
        lat = in.readString();
        country = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getRegion ()
    {
        return region;
    }

    public void setRegion (String region)
    {
        this.region = region;
    }

    public String getLocaltime ()
    {
        return localtime;
    }

    public void setLocaltime (String localtime)
    {
        this.localtime = localtime;
    }

    public String getLocaltime_epoch ()
    {
        return localtime_epoch;
    }

    public void setLocaltime_epoch (String localtime_epoch)
    {
        this.localtime_epoch = localtime_epoch;
    }

    public String getLon ()
    {
        return lon;
    }

    public void setLon (String lon)
    {
        this.lon = lon;
    }

    public String getTz_id ()
    {
        return tz_id;
    }

    public void setTz_id (String tz_id)
    {
        this.tz_id = tz_id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(region);
        dest.writeString(localtime);
        dest.writeString(localtime_epoch);
        dest.writeString(lon);
        dest.writeString(tz_id);
        dest.writeString(name);
        dest.writeString(lat);
        dest.writeString(country);
    }
}
