package com.example.vaccinenameapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Vaccine[] vList;
    public ItemClickListener  clickListener;
    public MyAdapter(Vaccine[] vList)
    {
        this.vList=vList;
    }
    public void setClickListener(ItemClickListener clickListener)
    {
        this.clickListener=clickListener;
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{
        public ImageView imageView;
        public TextView  textView;

        public MyViewHolder(@NonNull View itemView)  {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (clickListener != null){
                clickListener.onClick(view, getAdapterPosition());
            }
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View listItem=inflater.inflate(R.layout.recycler_view_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(listItem);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Vaccine vaccine=vList[position];
        holder.imageView.setImageResource(vaccine.getImage());
        holder.textView.setText(vaccine.getName());
    }

    @Override
    public int getItemCount() {
        return vList.length;
    }

}
