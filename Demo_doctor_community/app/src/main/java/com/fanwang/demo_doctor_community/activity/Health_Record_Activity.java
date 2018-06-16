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

public class Health_Record_Activity extends Populace_Activity {
    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.my_indent)
    LinearLayout myIndent;
    @BindView(R.id.rl_one)
    RelativeLayout rlOne;
    @BindView(R.id.health_education)
    LinearLayout healthEducation;
    @BindView(R.id.rl_jiben)
    RelativeLayout rlJiben;
    @BindView(R.id.rl_health)
    RelativeLayout rlHealth;
    @BindView(R.id.rl_binglie)
    RelativeLayout rl_binglie;

    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_record_activity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("健康档案", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.rl_jiben,R.id.rl_health,R.id.rl_binglie})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.rl_jiben:
                startActivity(new Intent(this, Health_Record_Activity_a.class));
                break;
            case R.id.rl_health:
                startActivity(new Intent(this, Edit_the_health.class));
                break;
            case R.id.rl_binglie:
                startActivity(new Intent(this,BingLie_Activity.class));
        }
    }
}
