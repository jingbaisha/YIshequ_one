package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.fragment.My_Order_Fragment_b;
import com.fanwang.demo_doctor_community.fragment.my.My_Order_Fragment_one;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edison on 2018/5/31.
 * 我的服务包
 */

public class My_serve_bao extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.stl_my)
    SlidingTabLayout stlMy;
    @BindView(R.id.vp_my_serve_bao)
    ViewPager vpMyServeBao;

    private String[] data={"服务中","已结束"};
    private ArrayList<Fragment> mList = new ArrayList<>();
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_serve_bao);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
         titleBackFragment = new TitleBackFragment().newInstance("", "我的服务包", "", "#23b1a5");
         addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        for (int i = 0; i < data.length; i++) {
            mList.add(new My_Order_Fragment_one().getParameter(data[i]));
        }
        mList.add(new My_Order_Fragment_one());
        vpMyServeBao.setAdapter(new MyViewpager(getSupportFragmentManager()));
        stlMy.setViewPager(vpMyServeBao);
    }

    public class MyViewpager extends FragmentPagerAdapter{

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
