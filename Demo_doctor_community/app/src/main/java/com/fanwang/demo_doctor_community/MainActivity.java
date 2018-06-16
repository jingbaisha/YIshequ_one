package com.fanwang.demo_doctor_community;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.fragment.home.Home_fragment;
import com.fanwang.demo_doctor_community.fragment.my.My_Fragment;
import com.fanwang.demo_doctor_community.fragment.serve.Serve_Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Populace_Activity implements View.OnClickListener {

    @BindView(R.id.fl_home)
    FrameLayout flHome;
    @BindView(R.id.iv_lin_home)
    ImageView ivLinHome;
    @BindView(R.id.lin_home)
    LinearLayout linHome;
    @BindView(R.id.iv_a)
    ImageView ivA;
    @BindView(R.id.lin_a)
    LinearLayout linA;
    @BindView(R.id.iv_b)
    ImageView ivB;
    @BindView(R.id.lin_b)
    LinearLayout linB;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.tv_servre)
    TextView tvServre;
    @BindView(R.id.tv_my)
    TextView tvMy;

    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Home_fragment home_fragment;
    private Serve_Fragment serve_fragment;
    private My_Fragment my_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        linHome.setOnClickListener(this);
        linA.setOnClickListener(this);
        linB.setOnClickListener(this);
        ivLinHome.setBackgroundResource(R.drawable.home_15);
        tvHome.setSelected(true);
        showorhit();
        fragmentTransaction = supportFragmentManager.beginTransaction();
        if (home_fragment == null) {
            home_fragment = new Home_fragment();
            fragmentTransaction.add(R.id.fl_home, home_fragment);
        }
        fragmentTransaction.show(home_fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void initData() {
        supportFragmentManager = getSupportFragmentManager();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_home:
                initShow(1);
                break;
            case R.id.lin_a:
                initShow(2);
                break;
            case R.id.lin_b:
                initShow(3);
                break;
        }
    }

    private void initShow(int i) {
        if (i == 1) {
            ivLinHome.setBackgroundResource(R.drawable.home_15);
            tvHome.setSelected(true);
        } else {
            ivLinHome.setBackgroundResource(R.drawable.home_15_no);
            tvHome.setSelected(false);
        }
        if (i == 2) {
            ivA.setBackgroundResource(R.drawable.home_16_yes);
            tvServre.setSelected(true);
        } else {
            ivA.setBackgroundResource(R.drawable.home_16);
            tvServre.setSelected(false);
        }
        if (i == 3) {
            ivB.setBackgroundResource(R.drawable.home_17_yes);
            tvMy.setSelected(true);
        } else {
            ivB.setBackgroundResource(R.drawable.home_17);
            tvMy.setSelected(false);
        }
        fragmentTransaction = supportFragmentManager.beginTransaction();
        showorhit();
        switch (i) {
            case 1:
                if (home_fragment == null) {
                    home_fragment = new Home_fragment();
                    fragmentTransaction.add(R.id.fl_home, home_fragment);
                } else {
                    fragmentTransaction.show(home_fragment);
                }
                break;

            case 2:
                if (serve_fragment == null) {
                    serve_fragment = new Serve_Fragment();
                    fragmentTransaction.add(R.id.fl_home, serve_fragment);
                } else {
                    fragmentTransaction.show(serve_fragment);
                }
                break;
            case 3:
                if (my_fragment == null) {
                    my_fragment = new My_Fragment();
                    fragmentTransaction.add(R.id.fl_home, my_fragment);
                } else {
                    fragmentTransaction.show(my_fragment);
                }
        }
        fragmentTransaction.commit();
    }

    private void showorhit() {
        if (home_fragment != null) {
            fragmentTransaction.hide(home_fragment);
        }
        if (serve_fragment != null) {
            fragmentTransaction.hide(serve_fragment);
        }
        if (my_fragment != null) {
            fragmentTransaction.hide(my_fragment);
        }
    }
}
