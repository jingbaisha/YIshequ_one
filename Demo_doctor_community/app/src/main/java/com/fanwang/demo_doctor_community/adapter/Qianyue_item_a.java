package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by edison on 2018/6/12.
 */

public class Qianyue_item_a extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private int[] data=new int[10];
    public Qianyue_item_a(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i]=1+i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.qianyue_item_a, parent, false);
        return new MyViewHoler_aa(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHoler_aa holer_aa= (MyViewHoler_aa) holder;
        holer_aa.textView.setText(data[position]+"许三");
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHoler_aa extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHoler_aa(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_qianyue_a);
        }
    }
}
