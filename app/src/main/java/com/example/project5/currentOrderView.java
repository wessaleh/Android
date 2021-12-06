package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class currentOrderView extends AppCompatActivity {

    TextView phoneNumber, subtotal, salesTax, orderTotal;
    ArrayList<Pizza> pizzas;
    StoreOrders storeOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order_view);

        Intent intent = getIntent();
        pizzas = (ArrayList<Pizza>) intent.getExtras().get("cart");
        storeOrders = (StoreOrders) intent.getExtras().get("store orders");

        // set the listview

        phoneNumber = findViewById(R.id.phoneNumber);
        subtotal = findViewById(R.id.subtotal);
        salesTax = findViewById(R.id.salesTax);
        orderTotal = findViewById(R.id.orderTotal);

        // set the values of all the textviews

    }
}