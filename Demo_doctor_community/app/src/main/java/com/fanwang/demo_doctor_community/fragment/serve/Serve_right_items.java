package com.fanwang.demo_doctor_community.fragment.serve;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.activity.Serve_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/5/25.
 */

public class Serve_right_items extends Fragment {

    @BindView(R.id.tv_shangmen)
    TextView tvShangmen;
    Unbinder unbinder;
    @BindView(R.id.tv_a)
    TextView tvA;
    @BindView(R.id.tv_b)
    TextView tvB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.serve_right_items, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

    }

    @OnClick({R.id.tv_shangmen, R.id.tv_a, R.id.tv_b})
    public void initOnclick(View view) {
        switch (view.getId()) {
            case R.id.tv_shangmen:
            case R.id.tv_a:
            case R.id.tv_b:
                Intent intent = new Intent(getContext(), Serve_Activity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
