package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Comment_detaisl_Adapter;
import com.fanwang.demo_doctor_community.adapter.DaiRenfu;
import com.fanwang.demo_doctor_community.adapter.Details_Adaper_b;
import com.fanwang.demo_doctor_community.adapter.Details_Adpter_a;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.StarBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/5/30.
 */

public class Details_a extends Populace_Activity {


    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.star_doctor)
    StarBar starDoctor;
    @BindView(R.id.rlv_details)
    RecyclerView rlvDetails;
    @BindView(R.id.rcy_serve_a)
    RecyclerView rcyServeA;
    @BindView(R.id.button_xiadan)
    Button buttonXiadan;
    @BindView(R.id.button_dai)
    Button buttonDai;
    @BindView(R.id.linear_tv_message)
    Button linearTvMessage;
    @BindView(R.id.lv_details)
    RecyclerView lvDetails;
    @BindView(R.id.iv_one)
    ImageView ivOne;
    @BindView(R.id.iv_two)
    ImageView ivTwo;

    private TitleBackFragment titleBackFragment;
    private Details_Adpter_a adpter;
    private Details_Adaper_b adaper_b;
    private Comment_detaisl_Adapter adapter;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_a);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "详情", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        //第一部分
        adpter = new Details_Adpter_a(this);
        GridLayoutManager layout = new GridLayoutManager(this, 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        rlvDetails.setLayoutManager(layout);
        rlvDetails.setAdapter(adpter);

        //第二部分
        adaper_b = new Details_Adaper_b(this);
        rcyServeA.setAdapter(adaper_b);
        GridLayoutManager layout1 = new GridLayoutManager(this, 1) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        rcyServeA.setLayoutManager(layout1);

        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_item_c));
        lvDetails.addItemDecoration(divider);

        //评论
        adapter = new Comment_detaisl_Adapter(this);
        LinearLayoutManager layout2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        lvDetails.setLayoutManager(layout2);
        lvDetails.setAdapter(adapter);
    }

    @OnClick({R.id.linear_tv_message, R.id.button_xiadan, R.id.button_dai, R.id.iv_one, R.id.iv_two})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.linear_tv_message:
                startActivity(new Intent(Details_a.this, Leave_Massage.class));
                break;
            case R.id.button_xiadan:
                intent = new Intent(Details_a.this, Down_order.class);
                startActivity(intent);
                break;
            case R.id.button_dai:
                startActivity(new Intent(Details_a.this, DaiRenfu.class));
                break;
            case R.id.iv_one:
            case R.id.iv_two:
                final MaterialDialog dialog = new MaterialDialog.Builder(this)
                        .customView(R.layout.dialog_quanbu, false)
                        .build();
                dialog.show();
                View iv_suofang= dialog.findViewById(R.id.iv_delet);
                iv_suofang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}
