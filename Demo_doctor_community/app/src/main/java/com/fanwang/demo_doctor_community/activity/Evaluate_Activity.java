package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.StarBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/14.
 */

public class Evaluate_Activity extends Populace_Activity {


    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.star_doctor)
    StarBar starDoctor;
    @BindView(R.id.st_a)
    StarBar stA;
    @BindView(R.id.st_b)
    StarBar stB;
    @BindView(R.id.login_tijiao)
    Button loginTijiao;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluate_activity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("评价服务", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        starDoctor.setStarMark(3f);
        stA.setStarMark(3f);
        stB.setStarMark(3f);
    }

    @OnClick({R.id.login_tijiao})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.login_tijiao:

                break;
        }
    }
}
