package com.fanwang.demo_doctor_community.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.activity.Doctor_details;
import com.fanwang.demo_doctor_community.activity.Leave_Massage;
import com.fanwang.demo_doctor_community.adapter.Apponoitment_c_Adapter;
import com.fanwang.demo_doctor_community.commonality.Popuplace_Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/6/6.
 */

public class Appointment_c extends Popuplace_Fragment {

    @BindView(R.id.rcv_yuyuedoctor)
    RecyclerView rcvYuyuedoctor;
    Unbinder unbinder;
    private Apponoitment_c_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.apponitment_b, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.recyclerview_item_a));
        rcvYuyuedoctor.addItemDecoration(divider);

        adapter = new Apponoitment_c_Adapter(getContext());
        rcvYuyuedoctor.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcvYuyuedoctor.setAdapter(adapter);
        adapter.SteOnClick_Items(new Apponoitment_c_Adapter.Onclick_Items() {
            @Override
            public void OnItems_Onclick(View view, int position) {
                startActivity(new Intent(getContext(), Doctor_details.class));
            }
        });
        //消息
        adapter.SteOnClick_Items_Massge(new Apponoitment_c_Adapter.Onclick_Items_Itmes() {
            @Override
            public void OnItems_Onclick_Items(View view, int position) {
                startActivity(new Intent(getContext(), Leave_Massage.class));
            }
        });
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
