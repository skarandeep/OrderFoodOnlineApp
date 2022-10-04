package com.example.orderfoodonlineapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.orderfoodonlineapp.Domains.CategoryDomain;
import com.example.orderfoodonlineapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {
    ArrayList<CategoryDomain> categoryDomain;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomain) {
        this.categoryDomain = categoryDomain;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.categoryName.setText(categoryDomain.get(position).getTitle());
        // viewHolder.TextView.setText(ArrayList.get(position).getTitle())
        String picUrl = "";
        switch(position){
            case 0:{
                picUrl = "cat_1";
                break;
            }
            case 1:{
                picUrl = "cat_2";
                break;
            }
            case 2:{
                picUrl = "cat_3";
                break;
            }
            case 3:{
                picUrl = "cat_4";
                break;
            }
            case 4:{
                picUrl = "cat_5";
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(picUrl, "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryImage);
    }

    @Override
    public int getItemCount() {
        return categoryDomain.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryImage;
        ConstraintLayout mainLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryImage = itemView.findViewById(R.id.categoryImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);



        }
    }

}
