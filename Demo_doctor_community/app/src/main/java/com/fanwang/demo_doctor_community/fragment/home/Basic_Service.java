package com.fanwang.demo_doctor_community.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Basic_adapte;
import com.fanwang.demo_doctor_community.commonality.Popuplace_Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/6/14.
 */

public class Basic_Service extends Popuplace_Fragment {

    @BindView(R.id.rcy_basic_servie)
    RecyclerView rcyBasicServie;
    Unbinder unbinder;
    private Basic_adapte basic_adapte;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.baic_service_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        basic_adapte = new Basic_adapte(getContext());
        rcyBasicServie.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcyBasicServie.setAdapter(basic_adapte);
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
