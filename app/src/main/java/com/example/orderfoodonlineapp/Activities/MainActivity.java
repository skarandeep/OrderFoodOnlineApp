package com.example.orderfoodonlineapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.orderfoodonlineapp.Adapters.CategoryAdapter;
import com.example.orderfoodonlineapp.Adapters.RecommendedAdapter;
import com.example.orderfoodonlineapp.Domains.CategoryDomain;
import com.example.orderfoodonlineapp.Domains.FoodDomain;
import com.example.orderfoodonlineapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter1,adapter2;
    private RecyclerView rvCategoryList, rvPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();

    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvPopularList = findViewById(R.id.recyclerView2);
        rvPopularList.setLayoutManager(linearLayoutManager);

        //after inserting "See more" text in layout
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza", "pizza1", "pepperoni slices, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce", 13.0, 5, 20, 1000));
        foodList.add(new FoodDomain("Cheese Burger", "burger", "beef, Gouda Cheese, Special sauce, Lettuce, tomato", 15.20, 4, 18, 1500));
        foodList.add(new FoodDomain("Vegetable pizza", "pizza3", "olive oil, vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 11.0, 3, 16, 800));

      adapter2 = new RecommendedAdapter(foodList);
      rvPopularList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvCategoryList = findViewById(R.id.recyclerView1);
        rvCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hotdog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));

        adapter1 = new CategoryAdapter(categoryList);
        rvCategoryList.setAdapter(adapter1);

    }
}