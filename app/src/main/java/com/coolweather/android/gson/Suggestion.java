package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * "suggestion":{
 *     "comf":{
 *         "txt":"白天天气较热，虽然有雨，但仍然无法削弱......"
 *     }
 *     "cw":{
 *         "txt":"不易洗车，未来24小时有雨......"
 *     }
 *     "sport":{
 *         "txt":"有降雨，且风力较强，建议你室内运动......"
 *     }
 * }
 *
 * */
public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;//舒适度，舒适建议

    @SerializedName("cw")
    public CarWash carWash;//洗车

    public Sport sport;//运动

    public class Comfort {

        @SerializedName("txt")
        public String info;

    }

    public class CarWash {

        @SerializedName("txt")
        public String info;

    }

    public class Sport {

        @SerializedName("txt")
        public String info;

    }

}
