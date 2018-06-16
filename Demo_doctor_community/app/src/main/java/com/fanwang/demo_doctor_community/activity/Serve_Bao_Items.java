package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Serve_Bao_Items extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tv_serve)
    TextView tvServe;
    @BindView(R.id.tv_yuyue_one)
    TextView tvYuyueOne;
    @BindView(R.id.tv_serve_a)
    TextView tvServeA;
    @BindView(R.id.tv_yuyue_two)
    TextView tvYuyueTwo;
    @BindView(R.id.tv_serve_b)
    TextView tvServeB;
    @BindView(R.id.tv_yuyue_three)
    TextView tvYuyueThree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_order_fragment_b);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("服务包详情", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }
    @OnClick({R.id.tv_yuyue_one,R.id.tv_yuyue_two,R.id.tv_yuyue_three})
    public void OnClickItems(View view){
        switch (view.getId()){
            case R.id.tv_yuyue_one:
            case R.id.tv_yuyue_two:
            case R.id.tv_yuyue_three:
                startActivity(new Intent(Serve_Bao_Items.this,Qianyue.class));
        }
    }
}
