package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by edison on 2018/5/25.
 */

public class Home_Lv extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[5];

    public Home_Lv(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = 6+i++;
        }
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHodler hodler;
        if (convertView==null){
            hodler=new MyViewHodler();
            convertView=inflater.inflate(R.layout.home_adapter,parent,false);
            hodler.textView=convertView.findViewById(R.id.tv_data);
            convertView.setTag(hodler);
        }else {
            hodler= (MyViewHodler) convertView.getTag();
        }
        hodler.textView.setText("2018-06-"+data[position]);
        return convertView;
    }
    class MyViewHodler{
        private TextView textView;
    }
}
