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
import com.fanwang.demo_doctor_community.fragment.My_Order_Fragment_a;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edison on 2018/5/31.
 * 我的订单
 */

public class My_Order extends Populace_Activity {
    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.stl_my_order)
    SlidingTabLayout stlMyOrder;
    @BindView(R.id.vp_my_order)
    ViewPager vpMyOrder;

    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] data = {"全部", "待付款", "待服务", "待评价", "已退款"};
    private int[] data_a={0,1,2,3,4};
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_order);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "我的订单", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        for (int i = 0; i < data_a.length; i++) {
            fragmentList.add(new My_Order_Fragment_a().getParameter(data_a[i]));
        }

        vpMyOrder.setAdapter(new MypagerAdapter(getSupportFragmentManager()));
        stlMyOrder.setViewPager(vpMyOrder);

    }

    public class MypagerAdapter extends FragmentPagerAdapter {

        public MypagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return data.length;
        }
    }
}
