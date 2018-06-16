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

public class My_order_fragment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "My_order_fragment";
    private Context context;
    private LayoutInflater inflater;
    private String[] data = {"全部", "代付款", "带服务", "待评价", "已退款"};

    private int Tag;

    public OnclickItems onclickItems;
    public OnclickItems_Items onclickItems_items;

    public interface OnclickItems {
        void SetOnclick(View view, int position);
    }

    public interface OnclickItems_Items {
        void SetOnclick_Items(View view, int position);
    }

    public void SetOnclick_Items(OnclickItems onclickItems) {
        this.onclickItems = onclickItems;
    }

    public void SetOnclick_Items_A(OnclickItems_Items onclickItems) {
        this.onclickItems_items = onclickItems;
    }

    public My_order_fragment(Context context, int Tag) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.Tag = Tag;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.order_fragment_adapter, parent, false);
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
                onclickItems_items.SetOnclick_Items(view, (Integer) view.getTag());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        Log.i(TAG, "onBindViewHolder: " + Tag);
        if (Tag == 0) {
            viewHolder.textView.setText(data[position]);
            viewHolder.button.setText(data[position]);
        } else if (Tag == 1) {
            viewHolder.button.setText("支付");
            viewHolder.textView.setText("代付款");
        } else if (Tag == 2) {
            viewHolder.button.setText("确认服务");
            viewHolder.textView.setText("带服务");
        } else if (Tag == 3) {
            viewHolder.button.setText("待评价");
            viewHolder.textView.setText("评价服务");
        } else if (Tag == 4) {
            viewHolder.button.setVisibility(View.GONE);
            viewHolder.textView.setText("已退款");
        }
        viewHolder.button.setTag(position);
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
            textView = itemView.findViewById(R.id.tv_dong_zhuantai);
            button = itemView.findViewById(R.id.but_dong_zhuangtai);
        }
    }
}
