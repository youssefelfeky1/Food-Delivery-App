package com.example.foodapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Model.CategoryDomain;
import com.example.foodapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> category;

    public CategoryAdapter(ArrayList<CategoryDomain> category) {
        this.category = category;
    }

    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
holder.categoryName.setText(category.get(position).getTitle());
String picurl = "";
switch(position){
    case 0:{
        picurl = "cat_1";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background1));
        break;
    }
    case 1:{
        picurl = "cat_2";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background2));
        break;
    }
    case 2:{
        picurl = "cat_3";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background3));
        break;
    }
    case 3:{
        picurl = "cat_4";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background4));
        break;
    }
    case 4:{
        picurl = "cat_5";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background5));
        break;
    }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picurl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryPic);

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryPic ;
        TextView categoryName;
        ConstraintLayout mainLayout;

        public ViewHolder(View item) {
            super(item);
            categoryName = item.findViewById(R.id.categoryName);
            categoryPic = item.findViewById(R.id.categoryPic);
            mainLayout = item.findViewById(R.id.mainLayout);
        }
    }
}
