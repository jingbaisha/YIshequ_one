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
import com.fanwang.demo_doctor_community.activity.My_Complaint_Item;
import com.fanwang.demo_doctor_community.adapter.My_complaint_Adapter;
import com.fanwang.demo_doctor_community.adapter.My_order_fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/5/31.
 * 投诉的Fragment
 */

public class My_Complaint_Fragment_a extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.tv_my_order)
    RecyclerView tvMyOrder;
    private String title;

    public My_Complaint_Fragment_a getParameter(String title) {
        My_Complaint_Fragment_a data = new My_Complaint_Fragment_a();
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

        My_complaint_Adapter adapter=new My_complaint_Adapter(getContext(),title);
        tvMyOrder.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        tvMyOrder.setAdapter(adapter);
        adapter.SetOnclick_Items(new My_complaint_Adapter.OnclickItems() {
            @Override
            public void SetOnclick(View view, int position) {
                startActivity(new Intent(getContext(), My_Complaint_Item.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
