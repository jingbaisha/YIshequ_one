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

public class My_doctor_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[10];
    public OnclickItems onclickItems;
    private Onclick_Items_Itmes onclick_items_itmes;

    public interface OnclickItems {
        void SetOnclick(View view, int position);
    }

    //消息
    public interface Onclick_Items_Itmes {
        void OnItems_Onclick_Items(View view, int position);
    }

    //消息
    public void SteOnClick_Items_Massge(Onclick_Items_Itmes onclick_items) {
        this.onclick_items_itmes = onclick_items;
    }

    public void SetOnclick_Items(OnclickItems onclickItems) {
        this.onclickItems=onclickItems;
    }

    public My_doctor_Adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.my_doctor_adpter_tuandui, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickItems.SetOnclick(v, (Integer) v.getTag());
            }
        });

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick_items_itmes.OnItems_Onclick_Items(v, (Integer) v.getTag());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.textView.setText(data[position] + "我");
        viewHolder.itemView.setTag(position);
        viewHolder.button.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button button;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_duizhang);
            button=itemView.findViewById(R.id.butSend_massge);
        }
    }
}
