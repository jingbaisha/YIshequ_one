package com.fanwang.demo_doctor_community.commonality;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by edison on 2018/5/17.
 */

public abstract class Populace_Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    /**
     * 功能说明：加入titlefragment到布局中
     * </p>作者：ts
     * 创建日期:2014-10-13
     * 参数：
     *
     * @param fragment 需要加入的fragment
     */
    final public void addTitleFragment(Fragment fragment) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.title_fragment_content, fragment);
        ft.commitAllowingStateLoss();
    }

    public abstract void initView();

    public abstract void initData();

}
