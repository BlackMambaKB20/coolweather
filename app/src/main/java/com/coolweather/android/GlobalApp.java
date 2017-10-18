package com.coolweather.android;

import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * 全局应用程序上下文
 * 方便 Preference 或 Sqlite 获取 Context
 * 千万不要忘了在Android项目的Manifest文件中指定Application的实现类，不然系统会创建一个默认的Application类。
 * 如果已经有自己的Application，那么就继承一下就好了，如下：
 * public class GlobalApp extends LitePalApplication
 */

public class GlobalApp extends LitePalApplication {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
