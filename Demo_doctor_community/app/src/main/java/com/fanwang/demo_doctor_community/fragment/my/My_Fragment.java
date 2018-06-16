package com.fanwang.demo_doctor_community.fragment.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.activity.Complaint_a;
import com.fanwang.demo_doctor_community.activity.Eat_Activity;
import com.fanwang.demo_doctor_community.activity.Health_Record_Activity_b;
import com.fanwang.demo_doctor_community.activity.Member_a;
import com.fanwang.demo_doctor_community.activity.My_Order;
import com.fanwang.demo_doctor_community.activity.My_serve_bao;
import com.fanwang.demo_doctor_community.activity.System_settings;
import com.fanwang.demo_doctor_community.activity.Touxiang;
import com.fanwang.demo_doctor_community.commonality.Popuplace_Fragment;
import com.fanwang.demo_doctor_community.custom.XCRoundImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chaoyue on 2018/5/18.
 */

public class My_Fragment extends Popuplace_Fragment {

    Unbinder unbinder;
    @BindView(R.id.iv_home_saoyisao)
    ImageView ivHomeSaoyisao;
    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.my_indent)
    LinearLayout myIndent;
    @BindView(R.id.my_serve)
    LinearLayout myServe;
    @BindView(R.id.my_chiyao_tixing)
    LinearLayout myChiyaoTixing;
    @BindView(R.id.my_complaint)
    LinearLayout myComplaint;
    @BindView(R.id.my_problem)
    LinearLayout myProblem;
    @BindView(R.id.xcr_touxiang)
    XCRoundImageView xcrTouxiang;
    @BindView(R.id.my_indent_rl)
    RelativeLayout myIndentRl;
    @BindView(R.id.my_serve_bao)
    RelativeLayout myServeBao;
    @BindView(R.id.my_eat_medicine)
    RelativeLayout myEatMedicine;
    @BindView(R.id.my_complaint_rl)
    RelativeLayout myComplaintRl;
    @BindView(R.id.my_problem_rl)
    RelativeLayout myProblemRl;
    @BindView(R.id.button_community_members)
    Button buttonCommunityMembers;
    @BindView(R.id.tv_my_name)
    TextView tvMyName;
    private Intent intent;
    @BindView(R.id.my_shezhi)
    RelativeLayout my_shezhi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

    }

    @OnClick({R.id.my_indent_rl, R.id.my_serve_bao, R.id.xcr_touxiang,
            R.id.my_complaint_rl, R.id.my_problem, R.id.button_community_members, R.id.my_eat_medicine, R.id.tv_my_name, R.id.my_shezhi})
    public void OnItemsOnclick(View view) {
        switch (view.getId()) {
            case R.id.my_indent_rl:
                intent = new Intent(getContext(), My_Order.class);
                startActivity(intent);
                break;
            case R.id.my_serve_bao:
                intent = new Intent(getContext(), My_serve_bao.class);
                startActivity(intent);
                break;

            case R.id.xcr_touxiang:
                intent = new Intent(getContext(), Touxiang.class);
                startActivity(intent);
                break;
            case R.id.my_complaint_rl:
                intent = new Intent(getContext(), Complaint_a.class);
                startActivity(intent);
                break;
            case R.id.my_problem:
                intent = new Intent(getContext(), Problem_a.class);
                startActivity(intent);
                break;
            case R.id.button_community_members:
                startActivity(new Intent(getContext(), Member_a.class));
                break;
            case R.id.my_eat_medicine:
                startActivity(new Intent(getContext(), Eat_Activity.class));
                break;
            case R.id.tv_my_name:
                startActivity(new Intent(getContext(), Health_Record_Activity_b.class));
                break;
            case R.id.my_shezhi:
                startActivity(new Intent(getContext(), System_settings.class));
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
