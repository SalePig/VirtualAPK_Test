package com.qiu.virtualapk_test.base;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.didi.virtualapk.PluginManager;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public class VAApplication extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        long start = System.currentTimeMillis();
        PluginManager.getInstance(base).init();
        Log.d("ryg", "use time:" + (System.currentTimeMillis() - start));
    }
}
