package com.example.ishant.weatherapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Condition implements Parcelable {

    @SerializedName("code")
    private Integer code;
    @SerializedName("text")
    private String text;
    @SerializedName("icon")
    private String icon;

    public Condition() {
        code = 1;
        text = "";
        icon = "";
    }

    protected Condition(Parcel in) {
        if (in.readByte() == 0) {
            code = 1;
        } else {
            code = in.readInt();
        }
        text = in.readString();
        icon = in.readString();
    }

    public static final Creator<Condition> CREATOR = new Creator<Condition>() {
        @Override
        public Condition createFromParcel(Parcel in) {
            return new Condition(in);
        }

        @Override
        public Condition[] newArray(int size) {
            return new Condition[size];
        }
    };

    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (code == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(code);
        }
        dest.writeString(text);
        dest.writeString(icon);
    }
}
