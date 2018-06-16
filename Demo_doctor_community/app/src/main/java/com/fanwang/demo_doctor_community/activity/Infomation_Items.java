package com.fanwang.demo_doctor_community.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Infomation_Items extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infomation_items);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
       titleBackFragment= new TitleBackFragment().newInstance("系统消息","#23b1a5");
       addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }
}
