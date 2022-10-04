package com.example.orderfoodonlineapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfoodonlineapp.Domains.FoodDomain;
import com.example.orderfoodonlineapp.Helpers.CartManagement;
import com.example.orderfoodonlineapp.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn, titleText, feeText, description, numberOrderText;
    private ImageView plusBtn, minusBtn, foodImage;
    private FoodDomain object;
    private int numberOrder = 1;
    private CartManagement cartManagement;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        cartManagement = new CartManagement(this);

        iniView();
    }

    private void iniView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        
    }
}