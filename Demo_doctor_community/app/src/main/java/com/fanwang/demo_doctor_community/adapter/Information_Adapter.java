package com.fanwang.demo_doctor_community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fanwang.demo_doctor_community.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Information_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private int[]  data={R.drawable.aa_10,R.drawable.aa_11,R.drawable.aa_12};
    private Onclick_Items onclick_items;
    private Onclick_Long_Items onclick_long_items;

    public interface Onclick_Items{
        void OnItems_Onclick(View view,int position);
    }

    public interface Onclick_Long_Items{
        void OnItems_Long_Onclick(View view,int position);
    }

    public void SteOnClick_Items(Onclick_Items onclick_items){
        this.onclick_items=onclick_items;
    }

    public void SteOn_Long_Click_Items(Onclick_Long_Items onclick_items){
        this.onclick_long_items=onclick_items;
    }

    public Information_Adapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewholder myViewholder = new MyViewholder(inflater.inflate(R.layout.information_adapter, parent, false));
        myViewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick_items.OnItems_Onclick(v, (Integer) v.getTag());
            }
        });

        myViewholder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onclick_long_items.OnItems_Long_Onclick(view, (Integer) view.getTag());
                return true;
            }
        });
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewholder myViewholder= (MyViewholder) holder;
        Glide.with(context).load(data[position]).into(myViewholder.imageView);
        myViewholder.itemView.setTag(position);
        myViewholder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewholder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        TextView textView;
        public MyViewholder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.xr_aa);
            textView=itemView.findViewById(R.id.tv_infotmation);
        }
    }
}
