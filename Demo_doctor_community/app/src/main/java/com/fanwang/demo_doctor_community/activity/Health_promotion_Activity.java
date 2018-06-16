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
import com.fanwang.demo_doctor_community.fragment.home.Health_Promotion_Fragment;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edison on 2018/6/6.
 */

public class Health_promotion_Activity extends Populace_Activity {


    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.stl_apponitment)
    SegmentTabLayout stlApponitment;
    @BindView(R.id.vp_my_apponiment)
    ViewPager vpMyApponiment;

    private TitleBackFragment titleBackFragment;
    private String[] data = {"健康知识", "健康新闻"};
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_promotion_activity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("健康宣传", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

        for (int i = 0; i < data.length; i++) {
            fragmentList.add(new Health_Promotion_Fragment().geInsta(data[i]));
        }
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
