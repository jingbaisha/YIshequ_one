package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Bingli_adapter;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/14.
 */

public class BingLie_Activity extends Populace_Activity {

    @BindView(R.id.rcy_binglie)
    RecyclerView rcyBinglie;
    @BindView(R.id.login_add)
    Button loginAdd;
    private Bingli_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.binglie);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        TitleBackFragment titleBackFragment = new TitleBackFragment().newInstance("详情", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_item));
        rcyBinglie.addItemDecoration(divider);

        adapter = new Bingli_adapter(this);
        rcyBinglie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcyBinglie.setAdapter(adapter);

        adapter.SetOnclick_Items(new Bingli_adapter.OnclickItems() {
            @Override
            public void SetOnclick(View view, int position) {
                startActivity(new Intent(BingLie_Activity.this, Binglie_Items_data.class));
            }
        });

        adapter.SteOnClick_Items_Delet(new Bingli_adapter.Onclick_Items_Itmes() {
            @Override
            public void OnItems_Onclick_Items(View view, int position) {
                final MaterialDialog dialog = new MaterialDialog.Builder(BingLie_Activity.this)
                        .customView(R.layout.dialog_information, false)
                        .build();
                dialog.show();
                View but_ok = dialog.findViewById(R.id.but_ok);
                View quuxiao = dialog.findViewById(R.id.bt_quxiao);
                but_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
//                       startActivity(new Intent(Sign_one.this,Signed_a_activity.class));
                    }
                });
                quuxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @OnClick({R.id.login_add})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.login_add:
                startActivity(new Intent(this, Add_New_Binglie.class));
                break;
        }
    }
}
