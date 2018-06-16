package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/14.
 */

public class Sign_one extends Populace_Activity {

    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.login_qianyue)
    Button loginQianyue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_one);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("签约", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }
    @OnClick({R.id.login_qianyue})
    public void OnclicItems(View view){
        switch (view.getId()){
            case R.id.login_qianyue:
                final MaterialDialog dialog = new MaterialDialog.Builder(this)
                        .customView(R.layout.dialog_c, false)
                        .build();
                dialog.show();

                View but_ok = dialog.findViewById(R.id.but_ok);
                View quuxiao = dialog.findViewById(R.id.bt_quxiao);
                but_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
//                       startActivity(new Intent(Sign_one.this,Signed_a_activity.class));
                    }
                });
                quuxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}
