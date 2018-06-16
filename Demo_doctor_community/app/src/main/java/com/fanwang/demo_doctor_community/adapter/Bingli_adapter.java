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
 * Created by edison on 2018/6/14.
 */

public class Bingli_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private int[] data = new int[10];
    private OnclickItems onclickItems;
    private Onclick_Items_Itmes onclick_items_itmes;

    public Bingli_adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < data.length; i++) {
            data[i] = 1 + i;
        }
    }

    public interface OnclickItems {
        void SetOnclick(View view, int position);
    }

    //消息
    public interface Onclick_Items_Itmes {
        void OnItems_Onclick_Items(View view, int position);
    }

    //消息
    public void SteOnClick_Items_Delet(Onclick_Items_Itmes onclick_items_it) {
        this.onclick_items_itmes = onclick_items_it;
    }

    public void SetOnclick_Items(OnclickItems onclickItems) {
        this.onclickItems = onclickItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.binglie_adapter, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickItems.SetOnclick(v, (Integer) v.getTag());
            }
        });

        myViewHolder.but_delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick_items_itmes.OnItems_Onclick_Items(v, (Integer) v.getTag());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText("我今儿看见去我空间" + data[position]);
        myViewHolder.but_delet.setTag(position);
        myViewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private Button button, but_delet;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_data);
            button = itemView.findViewById(R.id.but_item);
            but_delet = itemView.findViewById(R.id.but_delet);
        }
    }
}
