package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class currentOrderView extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView phoneNumber, subtotal, salesTax, orderTotal;
    ArrayList<Pizza> pizzas;
    StoreOrders storeOrders;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order_view);

        Intent intent = getIntent();
        pizzas = ((Order) intent.getExtras().get("cart")).pizzas;
        storeOrders = (StoreOrders) intent.getExtras().get("store orders");

        listView = findViewById(R.id.cart);
        phoneNumber = findViewById(R.id.phoneNumber);
        subtotal = findViewById(R.id.subtotal);
        salesTax = findViewById(R.id.salesTax);
        orderTotal = findViewById(R.id.orderTotal);

        System.out.println(pizzas);
        ArrayList<String> pizzaList = new ArrayList<String>();
        for(Pizza pizza: pizzas){
            pizzaList.add(pizza.toString());
        }

        listView.setOnItemClickListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, pizzaList);
        listView.setAdapter(arrayAdapter);
        // set the values of all the textviews

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}