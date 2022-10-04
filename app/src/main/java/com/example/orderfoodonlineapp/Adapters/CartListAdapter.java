package com.example.orderfoodonlineapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.orderfoodonlineapp.Domains.FoodDomain;
import com.example.orderfoodonlineapp.Helpers.CartManagement;
import com.example.orderfoodonlineapp.Interfaces.ChangeNumberItemsListener;
import com.example.orderfoodonlineapp.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.viewHolder> {
    ArrayList<FoodDomain> listFoodSelected;
    private CartManagement cartManagement;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<FoodDomain> listFoodSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listFoodSelected = listFoodSelected;
        cartManagement = new CartManagement(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new viewHolder(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(listFoodSelected.get(position).getTitle());
        holder.feeEachItem.setText("$" + listFoodSelected.get(position).getFee());
        holder.totalEachItem.setText("$" + Math.round(listFoodSelected.get(position).getNumberInCart()*listFoodSelected.get(position).getFee()));
        holder.num.setText(String.valueOf(listFoodSelected.get(position).getNumberInCart()));

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listFoodSelected.get(position).getImage(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);


        //replacing the onclicklisteners with lambda expressions, optional
        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartManagement.plusNumberFood(listFoodSelected, position, () -> {
                    notifyDataSetChanged();
                    changeNumberItemsListener.changed();
                });
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartManagement.minusNumberFood(listFoodSelected, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView title, feeEachItem, totalEachItem, num;
        ImageView pic, plusItem, minusItem;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_recommended);
            pic = itemView.findViewById(R.id.image_recommended);
            feeEachItem = itemView.findViewById(R.id.fee);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
            num = itemView.findViewById(R.id.numberItemText);


        }
    }

}
