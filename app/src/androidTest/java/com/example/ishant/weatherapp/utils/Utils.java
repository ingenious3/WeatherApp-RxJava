package com.example.ishant.weatherapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.ishant.weatherapp.data.ForecastResponse;
import com.google.gson.Gson;

public class Utils {
    public static ForecastResponse initialize(){
        String json = "{\"location\":{\"name\":\"Bangalore\",\"region\":\"Karnataka\",\"country\":\"India\",\"lat\":12.98,\"lon\":77.58,\"tz_id\":\"Asia/Kolkata\",\"localtime_epoch\":1525056435,\"localtime\":\"2018-04-30 8:17\"},\"current\":{\"last_updated_epoch\":1525054528,\"last_updated\":\"2018-04-30 07:45\",\"temp_c\":24.0,\"temp_f\":75.2,\"is_day\":1,\"condition\":{\"text\":\"Mist\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/143.png\",\"code\":1030},\"wind_mph\":10.5,\"wind_kph\":16.9,\"wind_degree\":260,\"wind_dir\":\"W\",\"pressure_mb\":1014.0,\"pressure_in\":30.4,\"precip_mm\":0.0,\"precip_in\":0.0,\"humidity\":100,\"cloud\":0,\"feelslike_c\":27.0,\"feelslike_f\":80.5,\"vis_km\":4.0,\"vis_miles\":2.0},\"forecast\":{\"forecastday\":[{\"date\":\"2018-04-30\",\"date_epoch\":1525046400,\"day\":{\"maxtemp_c\":34.6,\"maxtemp_f\":94.3,\"mintemp_c\":24.9,\"mintemp_f\":76.8,\"avgtemp_c\":29.5,\"avgtemp_f\":85.0,\"maxwind_mph\":16.6,\"maxwind_kph\":26.6,\"totalprecip_mm\":2.9,\"totalprecip_in\":0.11,\"avgvis_km\":19.0,\"avgvis_miles\":11.0,\"avghumidity\":48.0,\"condition\":{\"text\":\"Moderate or heavy rain shower\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/356.png\",\"code\":1243},\"uv\":12.7},\"astro\":{\"sunrise\":\"06:00 AM\",\"sunset\":\"06:34 PM\",\"moonrise\":\"06:59 PM\",\"moonset\":\"06:13 AM\"}},{\"date\":\"2018-05-01\",\"date_epoch\":1525132800,\"day\":{\"maxtemp_c\":36.1,\"maxtemp_f\":97.0,\"mintemp_c\":24.6,\"mintemp_f\":76.3,\"avgtemp_c\":29.8,\"avgtemp_f\":85.7,\"maxwind_mph\":12.8,\"maxwind_kph\":20.5,\"totalprecip_mm\":0.0,\"totalprecip_in\":0.0,\"avgvis_km\":19.9,\"avgvis_miles\":12.0,\"avghumidity\":47.0,\"condition\":{\"text\":\"Partly cloudy\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/116.png\",\"code\":1003},\"uv\":13.1},\"astro\":{\"sunrise\":\"05:59 AM\",\"sunset\":\"06:34 PM\",\"moonrise\":\"07:50 PM\",\"moonset\":\"06:57 AM\"}},{\"date\":\"2018-05-02\",\"date_epoch\":1525219200,\"day\":{\"maxtemp_c\":35.1,\"maxtemp_f\":95.2,\"mintemp_c\":25.9,\"mintemp_f\":78.6,\"avgtemp_c\":29.8,\"avgtemp_f\":85.6,\"maxwind_mph\":12.5,\"maxwind_kph\":20.2,\"totalprecip_mm\":0.0,\"totalprecip_in\":0.0,\"avgvis_km\":19.4,\"avgvis_miles\":12.0,\"avghumidity\":48.0,\"condition\":{\"text\":\"Partly cloudy\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/116.png\",\"code\":1003},\"uv\":13.0},\"astro\":{\"sunrise\":\"05:59 AM\",\"sunset\":\"06:35 PM\",\"moonrise\":\"08:41 PM\",\"moonset\":\"07:42 AM\"}},{\"date\":\"2018-05-03\",\"date_epoch\":1525305600,\"day\":{\"maxtemp_c\":36.2,\"maxtemp_f\":97.2,\"mintemp_c\":26.6,\"mintemp_f\":79.9,\"avgtemp_c\":30.9,\"avgtemp_f\":87.6,\"maxwind_mph\":8.3,\"maxwind_kph\":13.3,\"totalprecip_mm\":0.3,\"totalprecip_in\":0.01,\"avgvis_km\":19.3,\"avgvis_miles\":11.0,\"avghumidity\":43.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":14.0},\"astro\":{\"sunrise\":\"05:58 AM\",\"sunset\":\"06:35 PM\",\"moonrise\":\"09:32 PM\",\"moonset\":\"08:28 AM\"}},{\"date\":\"2018-05-04\",\"date_epoch\":1525392000,\"day\":{\"maxtemp_c\":34.7,\"maxtemp_f\":94.5,\"mintemp_c\":24.3,\"mintemp_f\":75.7,\"avgtemp_c\":29.9,\"avgtemp_f\":85.9,\"maxwind_mph\":11.0,\"maxwind_kph\":17.6,\"totalprecip_mm\":23.8,\"totalprecip_in\":0.94,\"avgvis_km\":18.7,\"avgvis_miles\":11.0,\"avghumidity\":50.0,\"condition\":{\"text\":\"Moderate or heavy rain shower\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/356.png\",\"code\":1243},\"uv\":39960.0},\"astro\":{\"sunrise\":\"05:58 AM\",\"sunset\":\"06:35 PM\",\"moonrise\":\"10:21 PM\",\"moonset\":\"09:15 AM\"}}]}}";

        Gson gson = new Gson();
        return gson.fromJson(json,ForecastResponse.class);
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
