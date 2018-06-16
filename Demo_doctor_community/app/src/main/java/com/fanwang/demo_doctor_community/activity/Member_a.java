package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Member_adapter;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/11.
 */

public class Member_a extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tv_ren)
    TextView tvRen;
    @BindView(R.id.but_upgrade)
    Button butUpgrade;
    @BindView(R.id.rcy_member_center)
    RecyclerView rcyMemberCenter;

    private TitleBackFragment titleBackFragment;
    private Member_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_center);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "会员中心", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        adapter = new Member_adapter(this);
        rcyMemberCenter.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcyMemberCenter.setAdapter(adapter);
    }

    @OnClick({R.id.but_upgrade})
    public void OnClickItems(View view) {
        switch (view.getId()) {
            case R.id.but_upgrade:
                startActivity(new Intent(this, Upgrade_Activity.class));
                break;
        }
    }
}
