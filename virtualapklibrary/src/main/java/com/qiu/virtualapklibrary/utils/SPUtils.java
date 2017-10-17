package com.qiu.virtualapklibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {

    public static final String PREFERNCE_FILE_NAME = "VirtualAPK_Test"; // 缓存文件名

    ///////////////////////////////通用的/////////////////////////////////////////////
    /**
     * 取布尔值
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences prefe = context.getSharedPreferences(PREFERNCE_FILE_NAME, 0);
        return prefe.getBoolean(key, defValue);

    }

    /**
     * 存布尔值
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences prefe = context.getSharedPreferences(PREFERNCE_FILE_NAME, 0);
        prefe.edit().putBoolean(key, value).commit();
    }
    /**
     * 存String方法
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value){
        SharedPreferences prefe = context.getSharedPreferences(PREFERNCE_FILE_NAME, 0);
        prefe.edit().putString(key, value).commit();
    }
    /**
     * 取String方法
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(Context context, String key, String defValue){
        SharedPreferences prefe = context.getSharedPreferences(PREFERNCE_FILE_NAME, 0);
        return prefe.getString(key, defValue);
    }

    /**
     * 存Int方法
     * @param context
     * @param key
     * @param value
     */
    public static void putInt(Context context, String key, int value){
        SharedPreferences prefe = context.getSharedPreferences(PREFERNCE_FILE_NAME, 0);
        prefe.edit().putInt(key, value).commit();
    }


    /**
     * 取Int方法
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(Context context, String key, int defValue){
        SharedPreferences prefe = context.getSharedPreferences(PREFERNCE_FILE_NAME, 0);
        int getInt = prefe.getInt(key, defValue);
        return getInt;
    }

    /**
     * 清除某个key对应的缓存
     * @param key
     * @param context
     */
    public static void clearByKey(String key, Context context) {
        SharedPreferences prefe = context.getSharedPreferences(PREFERNCE_FILE_NAME, 0);
        SharedPreferences.Editor editor = prefe.edit();
        editor.putString(key, "");
        editor.commit();
    }

    /**清除所有的缓存数据
     * @param context
     */
    public static void clearAll(Context context) {
        SharedPreferences prefe = context.getSharedPreferences(PREFERNCE_FILE_NAME, 0);
        SharedPreferences.Editor editor = prefe.edit();
        editor.clear();
        editor.commit();
    }

}

