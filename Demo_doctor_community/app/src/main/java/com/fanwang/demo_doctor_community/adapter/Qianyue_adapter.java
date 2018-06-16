package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by edison on 2018/6/12.
 */

public class Qianyue_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    //自主选择
    private static final int DATA_IMAGE = 0;
    //可选时间段
    private static final int SERVETIME = 1;

    public int currentType = DATA_IMAGE;

    public Qianyue_adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case DATA_IMAGE:
                currentType = DATA_IMAGE;
                break;
            case SERVETIME:
                currentType = SERVETIME;
                break;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DATA_IMAGE) {
            View view = inflater.inflate(R.layout.qianyue_adapter_a, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        } else if (viewType == SERVETIME) {
            return new MyViewHolder_one(inflater.inflate(R.layout.qianyue_item_b, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == DATA_IMAGE) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.setData();
        } else if (getItemViewType(position) == SERVETIME) {
            MyViewHolder_one holderOne = (MyViewHolder_one) holder;
            holderOne.setData_aa();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcy_qianyue);
        }

        public void setData() {
            Qianyue_item_a adapter = new Qianyue_item_a(context);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(adapter);
        }
    }

    class MyViewHolder_one extends RecyclerView.ViewHolder {
        private GridView gridView;

        public MyViewHolder_one(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gv_qianyue_item_b);
        }

        public void setData_aa() {
            Qianyue_gridview_Items adapter = new Qianyue_gridview_Items(context);
            gridView.setAdapter(adapter);
        }
    }

}
