package com.coolweather.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
        /**
         * client.newCall(request).enqueue(callback);
         * request的对象去构造得到一个Call对象，类似于将你的请求封装成了任务
         * 以异步的方式去执行请求，所以我们调用的是call.enqueue，将call加入调度队列，然后等待任务执行完成，
         * 我们在Callback中即可得到结果。
         * */
    }
}
