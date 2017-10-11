package com.coolweather.android.gson;
/**
 * AQI:Air Quality Index 空气质量指数
 *
 * "aqi":{
 *     "city":{
 *         "aqi":"44",
 *         "pm25":"13"
 *     }
 * }
 *
 * */
public class AQI {

    public AQICity city;

    public class AQICity {

        public String aqi;//Air Quality Index 空气质量指数

        public String pm25;//PM2.5

    }

}
