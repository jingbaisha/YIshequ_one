package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.adapter.Comment_detaisl_Adapter;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;
import com.fanwang.demo_doctor_community.custom.StarBar;
import com.fanwang.demo_doctor_community.custom.XCRoundImageView;
import com.fanwang.demo_doctor_community.fragment.Basic_Fragment;
import com.fanwang.demo_doctor_community.fragment.My_message;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/5/23.
 */

public class Doctor_details extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.view_one)
    View viewOne;
    @BindView(R.id.xri)
    XCRoundImageView xri;
    @BindView(R.id.tv_pingfeng)
    TextView tvPingfeng;
    @BindView(R.id.fengshu)
    TextView fengshu;
    @BindView(R.id.star_doctor)
    StarBar starDoctor;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.doctor_vp)
    ViewPager doctorVp;
    @BindView(R.id.lv_details)
    RecyclerView lvDetails;
    private TitleBackFragment titleBackFragment;
    @BindView(R.id.tl_doctor)
    TabLayout mTab;
    private String[] data = {"基本信息", "个人简历"};
    private Comment_detaisl_Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_details);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("详情", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {
        starDoctor.setStarMark(3.6f);
        addTab(mTab);

        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_item_c));
        lvDetails.addItemDecoration(divider);

        //评论
        adapter = new Comment_detaisl_Adapter(this);
        LinearLayoutManager layout2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        lvDetails.setLayoutManager(layout2);
        lvDetails.setAdapter(adapter);
    }
    @OnClick({R.id.button})
    public void Onclick(View view){
            switch (view.getId()){
                case R.id.button:
                    startActivity(new Intent(this,Evaluate_Activity.class));
                    break;
            }
    }
    private void addTab(TabLayout mTab) {
        for (int i = 0; i < data.length; i++) {
            TabLayout.Tab tab = mTab.newTab().setText(data[i]);
            tab.setText(data[i]);
            mTab.addTab(tab);
        }

        doctorVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new Basic_Fragment();
                    default:
                        return new My_message();
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 1:
                        return getString(R.string.mymessage);
                    default:
                        return getString(R.string.jibenxinxi);
                }
            }
        });
        mTab.setupWithViewPager(doctorVp);
    }

}
