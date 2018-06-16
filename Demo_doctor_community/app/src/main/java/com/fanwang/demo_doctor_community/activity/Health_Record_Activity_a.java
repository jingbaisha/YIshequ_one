package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Health_record_adapter;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Health_Record_Activity_a extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.rcy_items)
    RecyclerView rcyItems;
    @BindView(R.id.but_jibenxinxi)
    Button butJibenxinxi;
    @BindView(R.id.but_bianji)
    Button butBianji;
    private TitleBackFragment titleBackFragment;
    private Health_record_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_record_activity_a);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("基本信息", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        adapter = new Health_record_adapter(this);
        rcyItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcyItems.setAdapter(adapter);
    }
    @OnClick({R.id.but_bianji})
    public void SetOnclick(View view){
        switch (view.getId()){
            case R.id.but_bianji:
                startActivity(new Intent(this,Health_bianji.class));
                break;
        }
    }
}
