package com.fanwang.demo_doctor_community.fragment.home;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.zxing_google.android.CaptureActivity;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.activity.Carousel_Items;
import com.fanwang.demo_doctor_community.activity.Health_promotion_Activity;
import com.fanwang.demo_doctor_community.activity.Information;
import com.fanwang.demo_doctor_community.activity.My_Appointment;
import com.fanwang.demo_doctor_community.activity.My_Doctor;
import com.fanwang.demo_doctor_community.activity.My_Record;
import com.fanwang.demo_doctor_community.activity.School_health;
import com.fanwang.demo_doctor_community.activity.Signed_Activity;
import com.fanwang.demo_doctor_community.adapter.Home_Lv;
import com.fanwang.demo_doctor_community.commonality.OnChildScrollListener;
import com.fanwang.demo_doctor_community.commonality.Popuplace_Fragment;
import com.fanwang.demo_doctor_community.commonality.SideTopListView;
import com.fanwang.demo_doctor_community.custom.OnGroupScrollListener;
import com.fanwang.demo_doctor_community.custom.SideGroupLayout;
import com.jauker.widget.BadgeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;

import static android.support.v4.content.ContextCompat.checkSelfPermission;
import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;

/**
 * Created by edison on 2018/5/11.
 */

public class Home_fragment extends Popuplace_Fragment implements OnGroupScrollListener, OnChildScrollListener, BGABanner.Delegate {

    private static final String TAG = "Home_fragment";
    Unbinder unbinder;

    @BindView(R.id.banner_fresco_demo_content)
    BGABanner mBgaBanner;

    @BindView(R.id.sidegrouplayouut)
    SideGroupLayout sidegrouplayouut;
    @BindView(R.id.iv_yuyue)
    ImageView ivYuyue;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.iv_My_doctor)
    ImageView ivMyDoctor;

    @BindView(R.id.lin_lay_jkzs)
    LinearLayout linLayJkzs;
    @BindView(R.id.lin_jkxw)
    LinearLayout linJkxw;
    @BindView(R.id.lin_layout_stop)
    LinearLayout linLayoutStop;
    @BindView(R.id.lv_home)
    SideTopListView recyHome;
    @BindView(R.id.iv_show_left)
    ImageView ivShow_left;
    @BindView(R.id.iv_show_right)
    ImageView ivShow_right;
    @BindView(R.id.iv_show_more)
    LinearLayout ivShowMore;
    @BindView(R.id.iv_home_saoyisao)
    ImageView ivHomeSaoyisao;
    @BindView(R.id.iv_Campus_health)
    ImageView ivCampusHealth;
    @BindView(R.id.linear_Campus_health)
    LinearLayout linearCampusHealth;
    @BindView(R.id.iv_signed)
    ImageView ivSigned;
    @BindView(R.id.iv_record)
    ImageView iv_record;

    private BadgeView badgeView;
    private Home_Lv adapter;
    private static final int REQUEST_CODE_SCAN = 0x0000;
    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private Intent intent;

    /**
     * 1.展示数据
     * 2.点击进入详情页面
     */

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.home_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        mBgaBanner.setData(null, ImageView.ScaleType.CENTER_CROP,
                R.drawable.uoko_guide_background_1,
                R.drawable.uoko_guide_background_2,
                R.drawable.uoko_guide_background_3);

        adapter = new Home_Lv(getContext());
        recyHome.setAdapter(adapter);
        sidegrouplayouut.setOnGroupScrollListener(this);
        recyHome.setOnChildScrollListener(this);
        mBgaBanner.setDelegate(this);
    }

    private void initView() {
        badgeView = new BadgeView(getContext());
        badgeView.setTargetView(ivYuyue);
        badgeView.setBadgeCount(4);

        badgeView = new BadgeView(getContext());
        badgeView.setTargetView(ivMessage);
        badgeView.setBadgeCount(5);

        badgeView = new BadgeView(getContext());
        badgeView.setTargetView(ivMyDoctor);
        badgeView.setBadgeCount(5);

        badgeView = new BadgeView(getContext());
        badgeView.setTargetView(ivCampusHealth);
        badgeView.setBadgeCount(5);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public boolean isGroupScroll() {
        return recyHome != null && recyHome.isChildScrollToEnd();
    }

    @Override
    public void onScrollChanged(int left, int top) {

    }

    @Override
    public boolean isChildScroll() {
        return sidegrouplayouut != null && sidegrouplayouut.isScrollToEnd();
    }

    @OnClick({R.id.lin_jkxw, R.id.lin_lay_jkzs, R.id.iv_show_more, R.id.iv_home_saoyisao,
            R.id.Linear_My_appointment, R.id.linear_xiaoxi, R.id.linear_Campus_health,
            R.id.iv_signed, R.id.iv_My_doctor, R.id.iv_record})

    public void onClick(View v) {
        switch (v.getId()) {
            //健康新闻
            case R.id.lin_jkxw:
                initOnclick(1);
                break;
            //健康知识
            case R.id.lin_lay_jkzs:
                initOnclick(2);
                break;
            //点击显示更多
            case R.id.iv_show_more:
                startActivity(new Intent(getContext(), Health_promotion_Activity.class));
                break;
            case R.id.iv_home_saoyisao:
                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
                    } else {
                        Open();
                    }
                }
                break;
            //我的预约
            case R.id.Linear_My_appointment:
                intent = new Intent(getContext(), My_Appointment.class);
                startActivity(intent);
                break;
            //消息中心
            case R.id.linear_xiaoxi:
                intent = new Intent(getContext(), Information.class);
                startActivity(intent);
                break;
            //学校健康
            case R.id.linear_Campus_health:
                intent = new Intent(getContext(), School_health.class);
                startActivity(intent);
                break;
            //签约申请
            case R.id.iv_signed:
                intent = new Intent(getContext(), Signed_Activity.class);
                startActivity(intent);
                break;
            //我的医生
            case R.id.iv_My_doctor:
                intent = new Intent(getContext(), My_Doctor.class);
                startActivity(intent);
                break;
            //我的家庭
            case R.id.iv_record:
                startActivity(new Intent(getContext(), My_Record.class));
                break;
        }

    }

    private void initOnclick(int i) {
        if (i == 1) {
            ivShow_right.setVisibility(View.VISIBLE);
        } else {
            ivShow_right.setVisibility(View.GONE);
        }

        if (i == 2) {
            ivShow_left.setVisibility(View.VISIBLE);
        } else {
            ivShow_left.setVisibility(View.GONE);
        }
    }

    private void Open() {
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults[0] == PERMISSION_GRANTED) {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN && resultCode == -1) {
            if (data != null) {
                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);
//                resultTv.setText("解码结果： \n" + content);
            }
        }
    }

    @Override
    public void onBannerItemClick(BGABanner banner, View itemView, @Nullable Object model, int position) {
        startActivity(new Intent(getContext(), Carousel_Items.class));
    }
}
