package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/15.
 */

public class System_settings extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.my_indent)
    LinearLayout myIndent;
    @BindView(R.id.rl_xiugai)
    RelativeLayout rlXiugai;
    @BindView(R.id.rl_zhuxiao)
    RelativeLayout rlZhuxiao;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_seting);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("系统设置", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.rl_xiugai, R.id.rl_zhuxiao})
    public void SetOncclick(View view) {
        switch (view.getId()) {
            case R.id.rl_xiugai:
                startActivity(new Intent(this, Modification.class));
                break;
            case R.id.rl_zhuxiao:
                final MaterialDialog dialog = new MaterialDialog.Builder(this)
                        .customView(R.layout.dialog_zhuxiao, false)
                        .build();
                dialog.show();

                View ok = dialog.findViewById(R.id.but_ok);
                View quxiao = dialog.findViewById(R.id.bt_quxiao);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}
