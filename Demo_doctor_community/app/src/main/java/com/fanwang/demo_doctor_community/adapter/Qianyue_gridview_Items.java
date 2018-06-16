package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by edison on 2018/6/12.
 */

public class Qianyue_gridview_Items extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[10];

    public Qianyue_gridview_Items(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if (convertView == null) {
            holder = new MyViewHolder();
            convertView = inflater.inflate(R.layout.qianyue_gridview_items_a, parent, false);
            holder.textView = convertView.findViewById(R.id.tv_qianyue_aa);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        holder.textView.setText("1月19日上午" + data[position]);
        return convertView;
    }

    class MyViewHolder {
        TextView textView;
    }
}
