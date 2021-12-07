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

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author Wesam Saleh, Najibullah Assadullah
 */

public class storeOrderView extends AppCompatActivity{

    ListView pizzas;
    Spinner phoneNumbers;
    TextView orderTotal;
    ArrayAdapter adapter;

    private final double TAX_RATE = 0.06625;
    private final double TOTAL_RATE = 1 + TAX_RATE;
    private static final int NUM_DECIMAL_PLACES = 2;
    private static final int NUM_INT_PLACES = 1;
    private DecimalFormat money_Format;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order_view);

        // Initializing UI elements
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

        //Correct formatting
        money_Format = new DecimalFormat("###,###.00");
        money_Format.setMinimumFractionDigits(NUM_DECIMAL_PLACES);
        money_Format.setMinimumIntegerDigits(NUM_INT_PLACES);

        //Compute Order Total
    }

    // Computes total price of order
    private double orderTotalPrice(ArrayList<Pizza> pizzas){
        double orderTotal = 0.0;
        for (int i = 0; i < pizzas.size(); i++){
            orderTotal += pizzas.get(i).price();
        }
        orderTotal = orderTotal * TOTAL_RATE;
        return orderTotal;
    }
}
