package com.fanwang.demo_doctor_community.custom;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.fanwang.demo_doctor_community.R;

/**
 * Android�Զ���SearchView
 * Created by yuandl on 2016-11-17.
 */

public class SearchView extends LinearLayout implements TextWatcher, View.OnClickListener {
    /**
     * �����
     */
    private EditText et_search;
    /**
     * ����������Ǹ������ť
     */
    private Button bt_clear;

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**���ز����ļ�*/
        LayoutInflater.from(context).inflate(R.layout.pub_searchview, this, true);
        /***�ҳ��ؼ�*/
        et_search = (EditText) findViewById(R.id.et_search);
        bt_clear = (Button) findViewById(R.id.bt_clear);
        bt_clear.setVisibility(GONE);
        et_search.addTextChangedListener(this);
        bt_clear.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    /****
     * ���û��������ֵļ���
     *
     * @param editable
     */
    @Override
    public void afterTextChanged(Editable editable) {
        /**��ȡ��������**/
        String input = et_search.getText().toString().trim();
        if (input.isEmpty()) {
            bt_clear.setVisibility(GONE);
        } else {
            bt_clear.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        et_search.setText("");
    }
}
