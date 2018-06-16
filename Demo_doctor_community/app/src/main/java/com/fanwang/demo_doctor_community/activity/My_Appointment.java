package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.MyPagerAdapter;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.fragment.Appointment_a;
import com.fanwang.demo_doctor_community.fragment.Appointment_b;
import com.fanwang.demo_doctor_community.fragment.Appointment_c;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chaoyue on 2018/5/20.
 */

public class My_Appointment extends Populace_Activity {
    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.stl_apponitment)
    SegmentTabLayout stlApponitment;
    @BindView(R.id.vp_my_apponiment)
    ViewPager vpMyApponiment;

    private String[] data = {"待赴预约", "过期预约"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private MyPagerAdapter adapter;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_appointment);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("我的预约", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        fragmentList.add(new Appointment_a());
        fragmentList.add(new Appointment_b());
        stlApponitment.setTabData(data);
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList, data);
        vpMyApponiment.setAdapter(adapter);

        stlApponitment.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpMyApponiment.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        vpMyApponiment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                stlApponitment.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
