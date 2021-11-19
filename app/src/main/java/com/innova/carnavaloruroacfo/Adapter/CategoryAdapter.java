package com.innova.carnavaloruroacfo.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.innova.carnavaloruroacfo.Activity.ShowCategoryActivity;
import com.innova.carnavaloruroacfo.Activity.ShowDetailActivity;
import com.innova.carnavaloruroacfo.Domain.CategoryDomain;
import com.innova.carnavaloruroacfo.Domain.FoodDomain;
import com.innova.carnavaloruroacfo.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> CategoryDomains;
    ArrayList<FoodDomain> RecommendedDomains;


    public CategoryAdapter(ArrayList<CategoryDomain> CategoryDomains) {
        this.CategoryDomains = CategoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(CategoryDomains.get(position).getTitle());
//        String picUrl="";
//        switch (position) {
//            case 0: {
//                picUrl = "cat_1";
//                break;
//            }
//            case 1: {
//                picUrl = "cat_2";
//                break;
//            }
//            case 2: {
//                picUrl = "cat_3";
//                break;
//            }
//            case 3: {
//                picUrl = "cat_4";
//                break;
//            }
//            case 4: {
//                picUrl = "cat_5";
//                break;
//            }
//        }

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(CategoryDomains.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.categoryPic);
        holder.categoryPic.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowCategoryActivity.class);
            intent.putExtra("object", CategoryDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
//        Clide

    }


    @Override
    public int getItemCount() {
        return CategoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
