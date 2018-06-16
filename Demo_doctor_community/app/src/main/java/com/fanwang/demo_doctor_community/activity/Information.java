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
import com.fanwang.demo_doctor_community.adapter.Information_Adapter;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Information extends Populace_Activity {

    @BindView(R.id.login_information)
    Button loginInformation;
    @BindView(R.id.rcy_information)
    RecyclerView rcyInformation;
    private TitleBackFragment titleBackFragment;
    private Information_Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment=new TitleBackFragment().newInstance("消息中心","#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_item_b));
        rcyInformation.addItemDecoration(divider);

        rcyInformation.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new Information_Adapter(this);
        rcyInformation.setAdapter(adapter);

        adapter.SteOnClick_Items(new Information_Adapter.Onclick_Items() {
            @Override
            public void OnItems_Onclick(View view, int position) {
                Intent intent = new Intent(Information.this,Infomation_Items.class);
                startActivity(intent);
            }
        });

        adapter.SteOn_Long_Click_Items(new Information_Adapter.Onclick_Long_Items() {
            @Override
            public void OnItems_Long_Onclick(View view, int position) {
                final MaterialDialog dialog = new MaterialDialog.Builder(Information.this)
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
}
