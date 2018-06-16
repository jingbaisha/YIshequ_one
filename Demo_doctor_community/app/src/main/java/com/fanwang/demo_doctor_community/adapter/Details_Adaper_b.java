package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;

/**
 * Created by chaoyue on 2018/6/7.
 */

public class Details_Adaper_b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    private LayoutInflater inflater;
    public int currentType = DATA_IMAGE;

    //图片
    private static final int DATA_IMAGE = 0;
    //剩余服务时间
    private static final int SERVETIME = 1;

    public Details_Adaper_b(Context context) {
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
            return new MyViewHolder(inflater.inflate(R.layout.details_a_one, parent, false));
        } else if (viewType == SERVETIME) {
            return new MyViewHolder_one(inflater.inflate(R.layout.details_a_two, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == DATA_IMAGE) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.textView.setText("大数据凯迪拉克来得及看辣椒水恐问你你看完全可考虑 我看完几千块龙当家萨克道具卡垃圾袋块链接阿斯利康");
        } else if (getItemViewType(position) == SERVETIME) {
            MyViewHolder_one myViewHolder_one = (MyViewHolder_one) holder;
            myViewHolder_one.setData();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_details_a);
        }
    }

    class MyViewHolder_one extends RecyclerView.ViewHolder {
        GridView gridView;

        public MyViewHolder_one(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gv_details_a_two);
        }

        public void setData() {
            Details_a_Gridding adapter = new Details_a_Gridding(context);
            gridView.setAdapter(adapter);
        }
    }
}
