package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class storeOrderView extends AppCompatActivity{

    ListView pizzas;
    Spinner phoneNumbers;
    TextView orderTotal;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order_view);

        pizzas = findViewById(R.id.orders);
        phoneNumbers = findViewById(R.id.listOfPhoneNumbers);
        orderTotal = findViewById(R.id.orderTotal2);

        ArrayList<String> phoneNumbersList = new ArrayList<String>();
        for(Order order: MainActivity.storeOrders.orders){
            phoneNumbersList.add(order.phoneNumber);
        }

        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, phoneNumbersList);
        phoneNumbers.setAdapter(adapter);

        //populate listview with pizzas

        //Compute Order Total
    }
}
