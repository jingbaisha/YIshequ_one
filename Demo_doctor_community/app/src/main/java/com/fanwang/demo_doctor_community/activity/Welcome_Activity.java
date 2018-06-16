package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fanwang.demo_doctor_community.MainActivity;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;

/**
 * Created by edison on 2018/5/16.
 */

public class Welcome_Activity extends Populace_Activity {
    /**
     * 判断是否第一次进入  然后是否进入主页面
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        initData();
        initView();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(Welcome_Activity.this, MainActivity.class));
            }
        }.start();
    }
}
