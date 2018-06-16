package com.fanwang.demo_doctor_community.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by edison on 2018/6/1.
 */

public class MyPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> list;
    private String[] data;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> list, String[] data) {
        super(fm);
        this.list = list;
        this.data = data;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data[position];
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
