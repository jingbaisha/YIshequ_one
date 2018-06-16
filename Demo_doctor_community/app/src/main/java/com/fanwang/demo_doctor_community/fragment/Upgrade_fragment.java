package com.fanwang.demo_doctor_community.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Popuplace_Fragment;

/**
 * Created by edison on 2018/6/11.
 */

public class Upgrade_fragment extends Popuplace_Fragment{

    private String title;

    public Upgrade_fragment getParameter(String title) {
        Upgrade_fragment data = new Upgrade_fragment();
        this.title = title;
        return data;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upgrade_fragment, container, false);
        return view;
    }

}
