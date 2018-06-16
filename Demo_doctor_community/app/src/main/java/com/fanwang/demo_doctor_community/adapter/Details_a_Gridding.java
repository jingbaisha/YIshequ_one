package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by chaoyue on 2018/6/7.
 */

public class Details_a_Gridding extends BaseAdapter {
    private Context context;
    private int[] data = new int[10];
    private LayoutInflater inflater;

    public Details_a_Gridding(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i]=1+i;
        }
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.time_serve, parent, false);
            viewHolder.textView = convertView.findViewById(R.id.tv_data);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText("1月1" + data[position] + "日上午");
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }
}
