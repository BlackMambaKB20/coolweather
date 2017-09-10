package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Basic {

    @SerializedName("city")
    public String cityName;//城市名

    @SerializedName("id")
    public String weatherId;//城市对应的天气id

    public Update update;

    public class Update {

        @SerializedName("loc")//local    天气的更新时间
        public String updateTime;

    }

}
