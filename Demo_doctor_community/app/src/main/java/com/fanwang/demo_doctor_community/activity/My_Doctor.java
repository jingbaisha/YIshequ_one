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
import com.fanwang.demo_doctor_community.fragment.Appointment_c;
import com.fanwang.demo_doctor_community.fragment.My_Doctor_a;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edison on 2018/5/22.
 */

public class My_Doctor extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tl_3)
    SegmentTabLayout splMyDoctor;

    String[] data = new String[]{"我的家医", "预约医生"};
    @BindView(R.id.vp_my_doctor)
    ViewPager vpMyDoctor;

    private ArrayList<Fragment> mList = new ArrayList<>();
    private TitleBackFragment titleBackFragment;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_doctor);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("我的医生", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        mList.add(new My_Doctor_a());
        mList.add(new Appointment_c());
        adapter = new MyPagerAdapter(getSupportFragmentManager(), mList, data);
        vpMyDoctor.setAdapter(adapter);
        splMyDoctor.setTabData(data);

        splMyDoctor.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpMyDoctor.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        vpMyDoctor.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                splMyDoctor.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
