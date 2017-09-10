package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Now {

    @SerializedName("tmp")
    public String temperature;//温度

    @SerializedName("cond")//条件、情况、环境
    public More more;

    public class More {

        @SerializedName("txt")
        public String info;
    }

}
