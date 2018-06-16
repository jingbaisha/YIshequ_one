package com.fanwang.demo_doctor_community.fragment.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.activity.Problem_one;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/6/11.
 */

public class Problem_a extends Populace_Activity {
    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.my_indent)
    LinearLayout myIndent;
    @BindView(R.id.my_problem_a)
    RelativeLayout myProblemA;
    @BindView(R.id.health_education)
    LinearLayout healthEducation;
    @BindView(R.id.my_problem_b)
    RelativeLayout myProblemB;
    @BindView(R.id.my_problem_c)
    RelativeLayout myProblemC;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_a);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("常见问题", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.my_problem_a, R.id.my_problem_b, R.id.my_problem_c})
    public void OnItemsOnclick(View view) {
        switch (view.getId()) {
            case R.id.my_problem_a:
            case R.id.my_problem_b:
            case R.id.my_problem_c:
                startActivity(new Intent(this, Problem_one.class));
                break;
        }
    }
}
