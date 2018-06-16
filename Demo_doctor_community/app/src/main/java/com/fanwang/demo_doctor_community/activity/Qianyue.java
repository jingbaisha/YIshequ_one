package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Qianyue_adapter;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/12.
 */

public class Qianyue extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_time_but)
    Button tvTimeBut;
    @BindView(R.id.tv_time_but_a)
    Button tvTimeButA;
    @BindView(R.id.rcy_apponitment_a)
    RecyclerView rcyApponitmentA;
    @BindView(R.id.but_queren)
    Button button_queren;

    private Qianyue_adapter adapter;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_one);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("预约服务", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
    /*    LinearLayout layout1 = new GridLayoutManager(this, 1) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return super.canScrollVertically();
            }
        };

        adapter = new Qianyue_adapter(this);
        rcyApponitmentA.setLayoutManager(linearLayoutManager);
        rcyApponitmentA.setAdapter(adapter);
        tvTimeBut.setSelected(true);
    }

    @OnClick({R.id.tv_time_but, R.id.tv_time_but_a, R.id.but_queren})
    public void OnclicItems(View view) {
        switch (view.getId()) {
            case R.id.tv_time_but:
                init(1);
                break;
            case R.id.tv_time_but_a:
                init(2);
                break;
            case R.id.but_queren:
                startActivity(new Intent(Qianyue.this, Apponitment_details.class));
                finish();
                break;
        }
    }

    private void init(int i) {
        if (i == 1) {
            tvTimeBut.setSelected(true);
        } else {
            tvTimeBut.setSelected(false);
        }
        if (i == 2) {
            tvTimeButA.setSelected(true);
        } else {
            tvTimeButA.setSelected(false);
        }
    }
}
