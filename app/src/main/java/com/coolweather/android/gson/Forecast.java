package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

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
