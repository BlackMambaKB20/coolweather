package com.coolweather.android.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.coolweather.android.GlobalApp;

/**
 * SharedPreferences工具类
 */
public class PrefUtils {

    //自动定位模式 这儿和R.string.automatic_positioning相同
    private static final String PRE_AUTOMATIC_POSITIONING = "automatic_positioning";

    private static final String PRE_NAME = "com.coolweather.android";

    private static SharedPreferences getSharedPreferences1() {
        return GlobalApp.getContext().getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
    }

    public static boolean isAutomaticPositioning() {
        return getSharedPreferences1().getBoolean(PRE_AUTOMATIC_POSITIONING, false);
    }

    public static void setAutomaticPositioning(boolean isAutomaticPositioning) {
        SharedPreferences.Editor editor =getSharedPreferences1().edit();
        editor.putBoolean(PRE_AUTOMATIC_POSITIONING, isAutomaticPositioning);
        editor.commit();
    }

    //删除 SharedPreferences 的某个 key
    public static void removeFromPrefs(String key) {
        SharedPreferences.Editor editor = getSharedPreferences1().edit();
        editor.remove(key);
        editor.commit();
    }
}