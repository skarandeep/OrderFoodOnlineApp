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
import com.example.orderfoodonlineapp.Domains.FoodDomain;
import com.example.orderfoodonlineapp.R;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.viewHolder> {
    ArrayList<FoodDomain> RecommendedDomains;

    public RecommendedAdapter(ArrayList<FoodDomain> RecommendedDomains) {
        this.RecommendedDomains = RecommendedDomains;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended, parent, false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.title.setText(RecommendedDomains.get(position).getTitle());
//        String picUrl = "";
        holder.fee.setText(String.valueOf(RecommendedDomains.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(RecommendedDomains.get(position).getImage(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return RecommendedDomains.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView title, fee;
        ImageView pic, btnAdd;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_recommended);
            pic = itemView.findViewById(R.id.image_recommended);
            fee = itemView.findViewById(R.id.fee);
            btnAdd = itemView.findViewById(R.id.btnAdd);

        }
    }

}
