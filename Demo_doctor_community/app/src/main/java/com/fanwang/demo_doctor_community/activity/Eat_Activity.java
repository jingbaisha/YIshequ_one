package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Eat_adapter;
import com.fanwang.demo_doctor_community.bean.Eat_bean;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.SpinerPopWindow;

import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/12.
 */

public class Eat_Activity extends Populace_Activity {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    private TitleBackFragment titleBackFragment;
    private List<Eat_bean> list = new ArrayList<>();
    private Eat_adapter adapter;
    private List<String> list_Items = new ArrayList<>();
    private SpinerPopWindow<String> spinerPopWindow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eat_activity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("吃药提醒", "#23b1a5");
        addTitleFragment(titleBackFragment);
        list_Items.add("上午");
        list_Items.add("下午");
        spinerPopWindow = new SpinerPopWindow<>(this, list_Items, itemClickListener);
    }

    @Override
    public void initData() {
        Eat_bean bean = new Eat_bean();
        bean.setData("上午");
        bean.setTime("08:00");
        list.add(bean);

        adapter = new Eat_adapter(this, list);
        rcy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcy.setAdapter(adapter);
    }

    private OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            spinerPopWindow.dismiss();
        }
    };

    @OnClick({R.id.rl_add})
    public void addTime(View view) {
        switch (view.getId()) {
            case R.id.rl_add:
                final MaterialDialog dialog = new MaterialDialog.Builder(this)
                        .customView(R.layout.eat_time, false)
                        .build();
                dialog.show();
                View byId = dialog.findViewById(R.id.login_btn);
                final View rl_data = dialog.findViewById(R.id.rl_Data);

                byId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Eat_bean bean = new Eat_bean();
                        bean.setData("下午");
                        bean.setTime("16:00");
                        list.add(bean);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                rl_data.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spinerPopWindow.setWidth(rl_data.getWidth());
                        spinerPopWindow.showAsDropDown(rl_data);
                    }
                });
                break;
        }
    }
}
