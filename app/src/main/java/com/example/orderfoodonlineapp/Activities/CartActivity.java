package com.example.orderfoodonlineapp.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfoodonlineapp.Adapters.CartListAdapter;
import com.example.orderfoodonlineapp.Helpers.CartManagement;
import com.example.orderfoodonlineapp.Interfaces.ChangeNumberItemsListener;
import com.example.orderfoodonlineapp.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private CartManagement cartManagement;
    private TextView totalFeeText,taxText, deliveryText, totalText, emptyText;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartManagement = new CartManagement(this);


        initView();
        calculateCard();
        initList();
        

    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(cartManagement.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if(cartManagement.getListCart().isEmpty()){
            emptyText.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyText.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentTax = 0.133;
        double delivery = 10;
        tax = Math.round((cartManagement.getTotalFee()*percentTax)*100.0)/100.0;
        double total = Math.round((cartManagement.getTotalFee()+tax+delivery)*100.0)/100.0;
        double itemTotal = Math.round(cartManagement.getTotalFee()*100.0)/100.0;
        totalFeeText.setText("$" + itemTotal);
        taxText.setText("$" + tax);
        deliveryText.setText("$" + delivery);
        totalText.setText("$" + total);
    }

    private void initView() {
        totalFeeText = findViewById(R.id.totalFeeText);
        taxText = findViewById(R.id.taxText);
        deliveryText = findViewById(R.id.deliveryText);
        totalText = findViewById(R.id.totalText);
        recyclerViewList = findViewById(R.id.cart_recycler_view);
        scrollView = findViewById(R.id.scrollView2);
        emptyText = findViewById(R.id.emptyText);
    }
}
