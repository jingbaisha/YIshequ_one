package com.fanwang.demo_doctor_community.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor_community.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by edison on 2018/5/24.
 */

public class Basic_Fragment extends Fragment {

    @BindView(R.id.iv_one)
    ImageView ivOne;
    @BindView(R.id.iv_two)
    ImageView ivTwo;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basic_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_one, R.id.iv_two})
    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_one:
            case R.id.iv_two:
                final MaterialDialog dialog = new MaterialDialog.Builder(getContext())
                        .customView(R.layout.dialog_quanbu, false)
                        .build();
                dialog.show();
                View iv_suofang = dialog.findViewById(R.id.iv_delet);
                iv_suofang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}
