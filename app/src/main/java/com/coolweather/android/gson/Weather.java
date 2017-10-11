package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    /**
     * 返回天气格式:
     * {
     *          "HeWeather"[
     *                "status":"ok",   //代表请求状态
     *                "basic":{ },     //包含城市的基本信息
     *                "aqi":{ },       //包含当前空气质量的情况
     *                "now":{ },       //包含当前的空气信息
     *                "suggestion":{ },    //包含一些对天气相关的生活建议
     *                "daily_forecast":[]    //包含对未来几天的天气信息
     *          ]
     * }
     *
     * 根据LitePal的数据类型支持，可以进行对象关系映射的数据类型一共有8种，
     * int、short、long、float、double、boolean、String和Date。
     * 只要是声明成这8种数据类型的字段都会被自动映射到数据库表中，并不需要进行任何额外的配置。
     * */
    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;

}
