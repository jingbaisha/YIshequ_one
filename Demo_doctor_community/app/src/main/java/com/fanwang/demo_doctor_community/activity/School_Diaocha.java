package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/11.
 */

public class School_Diaocha extends Populace_Activity {
    @BindView(R.id.iv_back)
    ImageButton ivBack;
    @BindView(R.id.iv_home_genghuan)
    Button ivHomeGenghuan;
    @BindView(R.id.my_indent)
    LinearLayout myIndent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_diaocha);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.iv_back})
    public void OnItemsOnclick(View view){
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
