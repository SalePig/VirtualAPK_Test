package com.qiu.plugindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.qiu.virtualapklibrary.utils.SPUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        TextView tv_demo = (TextView) findViewById(R.id.tv_demo);
        String userid = SPUtils.getString(this, "userid", "不能公用");
        tv_demo.setText(userid);
    }
}
