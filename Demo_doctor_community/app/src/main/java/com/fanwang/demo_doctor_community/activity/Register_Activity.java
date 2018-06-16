package com.fanwang.demo_doctor_community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.commonality.Populace_Activity;
import com.fanwang.demo_doctor_community.commonality.TitleBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by edison on 2018/5/23.
 */

public class Register_Activity extends Populace_Activity {

    @BindView(R.id.title_fragment_content)
    LinearLayout titleFragmentContent;
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_password_queren)
    EditText loginPasswordQueren;
    @BindView(R.id.register_btn)
    Button registerBtn;
    private TitleBackFragment titleBackFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        titleBackFragment = new TitleBackFragment().newInstance("", "注册", "", "#23b1a5");
        addTitleFragment(titleBackFragment);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.register_btn})
    public void register_btn(View view) {
        switch (view.getId()) {
            case R.id.register_btn:
                startActivity(new Intent(this, Login_Activity.class));
                break;
        }
    }
}
