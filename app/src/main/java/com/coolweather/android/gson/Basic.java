package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;
/**
 * gson解析数据很简单   只需要一行代码就可以完成，但前提是先将数据对应的实体类创建好
 *
 * 在这里都采用了注解的方式来让json字段和java字段之间建立映射关系
 * 使用Gson解析json成对象时默认的是将json里对应字段的值解析到java对象里对应字段的属性里面。
 * 如果不一致的话，我们就可以使用@SerializedName注解来将对象里的属性跟json里字段对应值匹配起来。
 *
 * "basic":{
 *     "city":"苏州",
 *     "id":"CN101190401"
 *     "update":{
 *         "loc":"2017-09-18 17:38"
 *     }
 * }
 * */
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
