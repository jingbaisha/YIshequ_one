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
import com.fanwang.demo_doctor_community.fragment.my.My_Complaint_Fragment_a;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edison on 2018/6/11.
 * 我的投诉
 *
 */

public class Complaint_a extends Populace_Activity {
    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.tl_comlaint_a)
    SegmentTabLayout tlComlaintA;
    @BindView(R.id.vp_my_complaint_a)
    ViewPager vpMyComplaintA;

    private TitleBackFragment titleBackFragment;
    String[] data = new String[]{"待处理", "已处理"};
    private ArrayList<Fragment> mList = new ArrayList<>();
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaint_a);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("我的投诉", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

        for (int i = 0; i < data.length; i++) {
            mList.add(new My_Complaint_Fragment_a().getParameter(data[i]));
        }

        tlComlaintA.setTabData(data);
        adapter = new MyPagerAdapter(getSupportFragmentManager(), mList, data);
        vpMyComplaintA.setAdapter(adapter);

        tlComlaintA.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpMyComplaintA.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        vpMyComplaintA.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tlComlaintA.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
