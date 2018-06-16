package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.StarBar;
import com.fanwang.demo_doctor_community.fragment.My_Doctor_a;
import com.fanwang.demo_doctor_community.fragment.home.Basic_Service;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/1.
 */

public class Signed_a_activity extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.stl_tab_signed)
    SlidingTabLayout stlTabSigned;
    @BindView(R.id.stl_tab_vp)
    ViewPager stlTabVp;
    @BindView(R.id.star_doctor)
    StarBar starBar;

    private TitleBackFragment titleBackFragment;
    private String[] data = {"团队介绍", "基础服务", "增值服务"};
    private ArrayList<Fragment> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signed_a_activity);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "签约申请", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
//        for (int i = 0; i < data.length; i++) {
//            mList.add(new My_Order_Fragment_b().getParameter(data[i]));
//        }
        mList.add(new My_Doctor_a());
        mList.add(new Basic_Service());
        mList.add(new Basic_Service());
        stlTabVp.setAdapter(new MyViewpager(getSupportFragmentManager()));
        stlTabSigned.setViewPager(stlTabVp);
        starBar.setStarMark(3f);
    }

    @OnClick(R.id.login_qianyue)
    public void OnClickItem(View view) {
        switch (view.getId()) {
            case R.id.login_qianyue:
                startActivity(new Intent(this, Sign_one.class));
                break;
        }
    }

    public class MyViewpager extends FragmentPagerAdapter {

        public MyViewpager(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return data.length;
        }
    }

}
