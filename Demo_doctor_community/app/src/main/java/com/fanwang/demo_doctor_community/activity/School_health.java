package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/5/28.
 */

public class School_health extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;

    @BindView(R.id.my_indent)
    LinearLayout myIndent;
    @BindView(R.id.health_education)
    LinearLayout healthEducation;
    @BindView(R.id.rl_fabu_xinxi)
    RelativeLayout rlFabuXinxi;
    @BindView(R.id.rl_jiangkang)
    RelativeLayout rlJiangkang;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_health_activity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "学校健康", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.school_liuyan, R.id.rl_fabu_xinxi, R.id.rl_jiangkang})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.school_liuyan:
                startActivity(new Intent(School_health.this, School_liuyan.class));
                break;
            case R.id.rl_fabu_xinxi:
                startActivity(new Intent(School_health.this, Release_health.class));
                break;

            case R.id.rl_jiangkang:
                startActivity(new Intent(School_health.this, School_Diaocha.class));
                break;
        }
    }

}
