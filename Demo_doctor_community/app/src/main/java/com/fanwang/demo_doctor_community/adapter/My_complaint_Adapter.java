package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

public class My_complaint_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "My_order_fragment";
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[5];
    private String Tag;
    public OnclickItems onclickItems;

    public interface OnclickItems {
        void SetOnclick(View view, int position);
    }

    public void SetOnclick_Items(OnclickItems onclickItems) {
        this.onclickItems = onclickItems;
    }


    public My_complaint_Adapter(Context context, String Tag) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.Tag = Tag;
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.complaint_fragment_adapter, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickItems.SetOnclick(view, (Integer) view.getTag());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        if (Tag.equals("待处理")) {
            viewHolder.textView.setText("待处理");
        } else {
            viewHolder.textView.setText("已处理");
        }
        viewHolder.tv_doctor.setText("投诉原因" + data[position]);
        viewHolder.itemView.setTag(position);
        Log.i(TAG, "onBindViewHolder: " + Tag);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView, tv_doctor;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_dong_zhuantai);
            tv_doctor = itemView.findViewById(R.id.tv_doctor);
        }
    }
}
