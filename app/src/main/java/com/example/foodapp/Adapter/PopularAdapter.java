package com.example.foodapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Model.FoodDomain;
import com.example.foodapp.R;
import com.example.foodapp.ui.ShowDetailActivity;


import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<FoodDomain> popularFood;

    public PopularAdapter(ArrayList<FoodDomain> category) {
        this.popularFood = category;
    }

    @NonNull
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
      holder.title.setText(popularFood.get(position).getTitle());
      holder.fee.setText(String.valueOf( popularFood.get(position).getFee()));
      int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
      Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

      holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object",popularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic ;
        TextView title,fee;
        TextView addBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            fee = itemView.findViewById(R.id.feeTxt);
            addBtn = itemView.findViewById(R.id.addBtn);
            pic = itemView.findViewById(R.id.picImg);

        }
    }
}
