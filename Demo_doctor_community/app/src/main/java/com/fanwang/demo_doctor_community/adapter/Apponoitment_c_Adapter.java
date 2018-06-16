package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by edison on 2018/6/6.
 */

public class Apponoitment_c_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[10];
    private Onclick_Items onclick_items;
    private Onclick_Items_Itmes onclick_items_itmes;

    //详情
    public interface Onclick_Items {
        void OnItems_Onclick(View view, int position);
    }

    //消息
    public interface Onclick_Items_Itmes {
        void OnItems_Onclick_Items(View view, int position);
    }
    //详情
    public void SteOnClick_Items(Onclick_Items onclick_items) {
        this.onclick_items = onclick_items;
    }
    //消息
    public void SteOnClick_Items_Massge(Onclick_Items_Itmes onclick_items) {
        this.onclick_items_itmes = onclick_items;
    }

    public Apponoitment_c_Adapter(Context context) {
        this.context = context;
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
        inflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.apponitment_list_b, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        //发送消息
        holder.but_massege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick_items_itmes.OnItems_Onclick_Items(v, (Integer) v.getTag());
            }
        });

        //详情
        holder.but_items_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick_items.OnItems_Onclick(view, (Integer) view.getTag());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textView.setText(data[position] + "无敌");
        viewHolder.but_massege.setTag(position);
        viewHolder.but_items_data.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button but_items_data, but_massege;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_ren);
            but_massege = itemView.findViewById(R.id.but_massege);
            but_items_data = itemView.findViewById(R.id.but_items_data);
        }
    }
}
