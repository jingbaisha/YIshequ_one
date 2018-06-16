package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by edison on 2018/6/6.
 */

public class Apponoitment_b_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[10];
    private Apponoitment_a_Adapter.Onclick_Items onclick_items;

    public interface Onclick_Items{
        void OnItems_Onclick(View view,int position);
    }
    public void SteOnClick_Items(Apponoitment_a_Adapter.Onclick_Items onclick_items){
        this.onclick_items=onclick_items;
    }

    public Apponoitment_b_Adapter(Context context) {
        this.context = context;
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
        inflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.apponitment_aa, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
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
        viewHolder.textView.setText(data[position] + "号");
        viewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_doctor_hao);
        }
    }
}
