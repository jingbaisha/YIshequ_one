package com.fanwang.demo_doctor_community.fragment.home;

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
import com.fanwang.demo_doctor_community.activity.Health_Promotion_fragment_a;
import com.fanwang.demo_doctor_community.adapter.Health_Promotion_Adapter;
import com.fanwang.demo_doctor_community.commonality.Popuplace_Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/6/6.
 */

public class Health_Promotion_Fragment extends Popuplace_Fragment {

    @BindView(R.id.rcy_health_fragment)
    RecyclerView rcyHealthFragment;
    Unbinder unbinder;
    private Health_Promotion_Adapter adapter;
    private String Tag;

    public static  Health_Promotion_Fragment geInsta(String Tag) {
        Health_Promotion_Fragment hf=new Health_Promotion_Fragment();
        hf.Tag=Tag;
        return hf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.health_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {

    }

    private void initView() {

        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.recyclerview_item_b));
        rcyHealthFragment.addItemDecoration(divider);

        adapter = new Health_Promotion_Adapter(getContext());
        rcyHealthFragment.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rcyHealthFragment.setAdapter(adapter);
        adapter.GetOnclickItems(new Health_Promotion_Adapter.OnclickItem() {
            @Override
            public void SetOnclickItems(int position, View view) {
                    startActivity(new Intent(getContext(), Health_Promotion_fragment_a.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
