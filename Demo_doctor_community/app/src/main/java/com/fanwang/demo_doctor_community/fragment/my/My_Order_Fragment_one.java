package com.fanwang.demo_doctor_community.fragment.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.activity.Evaluate_Activity;
import com.fanwang.demo_doctor_community.activity.Serve_Bao_Items;
import com.fanwang.demo_doctor_community.adapter.My_order_adapter_one;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/5/31.
 * 我的服务包Fragment
 */

public class My_Order_Fragment_one extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.tv_my_order)
    RecyclerView tvMyOrder;
    private String title;
    private My_order_adapter_one adapter;

    public My_Order_Fragment_one getParameter(String title) {
        My_Order_Fragment_one data = new My_Order_Fragment_one();
        data.title = title;
        return data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_order_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.recyclerview_item_c));
        tvMyOrder.addItemDecoration(divider);

        adapter = new My_order_adapter_one(getContext(), title);
        tvMyOrder.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        tvMyOrder.setAdapter(adapter);
        adapter.SetOnclick_Items(new My_order_adapter_one.OnclickItems() {
            @Override
            public void SetOnclick(View view, int position) {
                startActivity(new Intent(getContext(), Serve_Bao_Items.class));
            }
        });

        //跳转到评价
        adapter.SetOnclick_Items_But(new My_order_adapter_one.OnclickItems_but() {
            @Override
            public void SetOnclick(View view, int position) {
                startActivity(new Intent(getContext(), Evaluate_Activity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
