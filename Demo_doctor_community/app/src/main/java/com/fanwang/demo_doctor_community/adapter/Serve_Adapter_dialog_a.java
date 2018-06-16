package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by edison on 2018/6/11.
 */

public class Serve_Adapter_dialog_a extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[10];

    public Serve_Adapter_dialog_a(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = i++;
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
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.serve_adapter_dialog, parent, false);
            holder.textView = convertView.findViewById(R.id.tv_serve_adapter);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText("福力医院" + data[position]);
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }

}
