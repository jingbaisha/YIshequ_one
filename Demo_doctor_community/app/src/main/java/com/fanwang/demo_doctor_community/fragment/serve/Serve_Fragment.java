package com.fanwang.demo_doctor_community.fragment.serve;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.activity.Serve_Activity;
import com.fanwang.demo_doctor_community.adapter.Serve_Adapter_dialog_a;
import com.fanwang.demo_doctor_community.custom.MenuItem;
import com.fanwang.demo_doctor_community.custom.TopRightMenu;
import com.fanwang.demo_doctor_community.dialog.Dialog_xuanze;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chaoyue on 2018/5/18.
 */

public class Serve_Fragment extends Fragment {

    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.login_btn)
    Button loginBtn;

    Unbinder unbinder;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.lin_lay_search)
    RelativeLayout linLaySearch;
    @BindView(R.id.rb_one)
    RadioButton rbOne;
    @BindView(R.id.rb_two)
    RadioButton rbTwo;
    @BindView(R.id.rb_three)
    RadioButton rbThree;
    @BindView(R.id.rl_doctor)
    RelativeLayout rl_doctor;

    private FragmentTransaction fragmentTransaction;
    private FragmentTransaction ft;
    private String phoneNumber = "13250293984";
    private TopRightMenu mTopRightMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.serve_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        rbOne.setChecked(true);
        fragmentTransaction = getFragmentManager().beginTransaction();
        ft = this.fragmentTransaction.replace(R.id.fl_right, new Serve_right_items());
        fragmentTransaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rb_one, R.id.rb_two, R.id.rb_three, R.id.login_btn, R.id.rl_doctor})
    public void OnItemsOnclick(View view) {
        switch (view.getId()) {
            case R.id.rb_one:
            case R.id.rb_two:
            case R.id.rb_three:
                fragmentTransaction = getFragmentManager().beginTransaction();
                ft = this.fragmentTransaction.replace(R.id.fl_right, new Serve_right_items());
                fragmentTransaction.commit();
                break;
            case R.id.login_btn:
                final MaterialDialog dialog = new MaterialDialog.Builder(getContext())
                        .customView(R.layout.dialog_a, false)
                        .build();
                dialog.show();
                View ok = dialog.findViewById(R.id.but_ok);
                View quxiao = dialog.findViewById(R.id.but_quxiao);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber)));
                        dialog.dismiss();
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.rl_doctor:
                Dialog_xuanze dialog_xuanze = new Dialog_xuanze();
                dialog_xuanze.ShowDialog(rl_doctor, getActivity());
                break;
        }
    }
}
