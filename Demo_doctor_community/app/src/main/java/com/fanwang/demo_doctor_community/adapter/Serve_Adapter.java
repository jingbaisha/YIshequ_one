package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanwang.demo_doctor_community.R;
import com.fanwang.demo_doctor_community.custom.StarBar;

/**
 * Created by edison on 2018/5/30.
 */

public class Serve_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private LayoutInflater inflater;
    private Viewholder holder;
    private String[] data={"王小波","王小波"};
    private OnclickItem onclickItem;
    public interface OnclickItem{
        void SetOnclickItems(int position,View view);
    }
    public void GetOnclickItems(OnclickItem onclickItem){
        this.onclickItem=onclickItem;
    }

    public Serve_Adapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.serve_activity_a, parent, false);
        holder = new Viewholder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickItem.SetOnclickItems((int) v.getTag(),v);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Viewholder viewholder= (Viewholder) holder;
        viewholder.textView.setText(data[position]);
        viewholder.itemView.setTag(position);
        viewholder.starBar.setStarMark(3.6f);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class Viewholder extends RecyclerView.ViewHolder{
        TextView textView;
        StarBar starBar;

        public Viewholder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_name);
            starBar=itemView.findViewById(R.id.star_doctor);
        }
    }
}
