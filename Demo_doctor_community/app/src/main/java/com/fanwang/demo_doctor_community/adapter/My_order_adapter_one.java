package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

public class My_order_adapter_one extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "My_order_fragment";
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[5];
    private String Tag;

    public OnclickItems onclickItems;
    public OnclickItems_but onclickItems_but;

    public interface OnclickItems {
        void SetOnclick(View view, int position);
    }

    public interface OnclickItems_but {
        void SetOnclick(View view, int position);
    }

    public void SetOnclick_Items(OnclickItems onclickItems) {
        this.onclickItems = onclickItems;
    }

    public void SetOnclick_Items_But(OnclickItems_but onclickItems) {
        this.onclickItems_but = onclickItems;
    }


    public My_order_adapter_one(Context context, String Tag) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.Tag = Tag;
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.order_fragment_adapter_one, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickItems.SetOnclick(view, (Integer) view.getTag());
            }
        });

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickItems_but.SetOnclick(view, (Integer) view.getTag());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        Log.i(TAG, "onBindViewHolder: " + Tag);
        if (Tag.equals("已结束")) {
            viewHolder.button.setVisibility(View.VISIBLE);
            viewHolder.button.setTag(position);
        }
        viewHolder.textView.setText("孕妇服务包" + data[position]);
        viewHolder.itemView.setTag(position);
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
            textView = itemView.findViewById(R.id.tv_name);
            button = itemView.findViewById(R.id.but_dong_zhuangtai);
        }
    }
}
