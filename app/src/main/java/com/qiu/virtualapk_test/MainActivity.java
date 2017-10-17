package com.qiu.virtualapk_test;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;
import com.qiu.virtualapk_test.base.PluginPackgeName;
import com.qiu.virtualapklibrary.utils.SPUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Button openPlugin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //加载插件
        loadPlugin(this);
        SPUtils.putString(this,"userid" ,"13545213172");
        openPlugin = (Button) findViewById(R.id.open_plugin);
        openPlugin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                loadPlugin(MainActivity.this);
                openPluginActivity();
            }
        });
    }

    private void openPluginActivity(){
        if (PluginManager.getInstance(this).getLoadedPlugin(PluginPackgeName.PluginDemoPackgeName) == null) {
            Toast.makeText(this, "插件未加载", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(PluginPackgeName.PluginDemoPackgeName, PluginPackgeName.PluginDemoPackgeNameMainActivity);
        startActivity(intent);
    }

    private void loadPlugin(Context context){
        PluginManager pluginManager = PluginManager.getInstance(context);
        File apk = new File(Environment.getExternalStorageDirectory(), PluginPackgeName.PluginAPK);
        if (apk.exists()) {
            try {
                pluginManager.loadPlugin(apk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
