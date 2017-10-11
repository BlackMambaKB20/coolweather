package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * "daily_forecast":[
 *      {
 *          "date":"2017-09-18",
 *          "cond":"txt_d":"阵雨"
 *          "tmp":{
 *               "max":"34",
 *               "min":"27"
 *           }
 *       },
 *       {
 *          "date":"2017-09-19",
 *          "cond":"txt_d":"多云"
 *          "tmp":{
 *               "max":"35",
 *               "min":"27"
 *           }
 *       }
 * ]
 *
 * */
public class Forecast {

    public String date;//日期

    @SerializedName("tmp")
    public Temperature temperature;//当日温度

    @SerializedName("cond")//当日天气状况
    public More more;

    public class Temperature {

        public String max;

        public String min;

    }

    public class More {

        @SerializedName("txt_d")
        public String info;
    }
}
