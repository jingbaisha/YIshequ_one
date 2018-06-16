package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.DaiRenfu;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.StarBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/5/31.
 */

public class Down_order extends Populace_Activity {


    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.star_doctor)
    StarBar starDoctor;
    @BindView(R.id.linear_genghuan)
    LinearLayout linearGenghuan;
    @BindView(R.id.linear_baoxian)
    LinearLayout linearBaoxian;
    @BindView(R.id.login_zhifu)
    Button loginZhifu;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_order);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("服务下单", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.linear_baoxian, R.id.linear_genghuan})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.linear_baoxian:
                startActivity(new Intent(this, Insurance_a.class));
                break;
            case R.id.linear_genghuan:
                startActivity(new Intent(this, DaiRenfu.class));
                break;
        }
    }
}
