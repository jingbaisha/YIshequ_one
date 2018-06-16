package com.fanwang.demo_doctor_community.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanwang.demo_doctor_community.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/5/31.
 */

public class My_Order_Fragment_b extends Fragment {

    Unbinder unbinder;
    private String title;

    public My_Order_Fragment_b getParameter(String title) {
        My_Order_Fragment_b data = new My_Order_Fragment_b();
        this.title = title;
        return data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_order_fragment_b, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
