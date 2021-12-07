package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author Wesam Saleh, Najibullah Assadullah
 */

public class currentOrderView extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Button remove, placeOrderButton;
    TextView phoneNumber, subtotal, salesTax, orderTotal;
    ArrayList<Pizza> pizzas;
    StoreOrders storeOrders;
    ListView listView;
    ArrayAdapter adapter;
    int selectedIndex;

    private final double TAX_RATE = 0.06625;
    private final double TOTAL_RATE = 1 + TAX_RATE;
    private static final int NUM_DECIMAL_PLACES = 2;
    private static final int NUM_INT_PLACES = 1;
    private DecimalFormat money_Format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order_view);

        Intent intent = getIntent();
        pizzas = MainActivity.currentOrder.pizzas;

        storeOrders = (StoreOrders) intent.getExtras().get("store orders");

        // Initializing UI elements
        listView = findViewById(R.id.cart);
        phoneNumber = findViewById(R.id.customerPhoneNumber);
        subtotal = findViewById(R.id.subtotal);
        salesTax = findViewById(R.id.salesTax);
        orderTotal = findViewById(R.id.orderTotal);
        remove = findViewById(R.id.button);
        placeOrderButton = findViewById(R.id.placeOrderButton);

        remove.setOnClickListener(this::remove);

        selectedIndex = 0;
        ArrayList<String> pizzaList = new ArrayList<String>();
        for(Pizza pizza: pizzas){
            pizzaList.add(pizza.toString());
        }

        listView.setOnItemClickListener(this);
        placeOrderButton.setOnClickListener(this::placeOrder);
        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, pizzaList);
        listView.setAdapter(adapter);

        // Sets format
        money_Format = new DecimalFormat("###,###.00");
        money_Format.setMinimumFractionDigits(NUM_DECIMAL_PLACES);
        money_Format.setMinimumIntegerDigits(NUM_INT_PLACES);

        // Sets the values of all the textviews
        subtotal.setText("" + money_Format.format(subTotalPrice(pizzas)));
        salesTax.setText("" + money_Format.format(subTotalPrice(pizzas) * TAX_RATE));
        orderTotal.setText("" + money_Format.format(subTotalPrice(pizzas) * TOTAL_RATE));
        phoneNumber.setText("Customer Phone Number: " + intent.getExtras().get("phone"));

    }

    // Removes pizza from order
    public void remove(View view){
        MainActivity.currentOrder.pizzas.remove(selectedIndex);
        adapter.remove(selectedIndex);

        Toast toast = Toast.makeText(getApplicationContext(),
                "Please exit and come back to view updated order", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectedIndex = position;
    }

    // Places order
    public void placeOrder(View view){
        Order order = new Order();
        order.pizzas = new ArrayList<Pizza>(MainActivity.currentOrder.pizzas);
        order.phoneNumber = new String(MainActivity.currentOrder.phoneNumber);

        MainActivity.storeOrders.orders.add(order);
    }

    // Computes subtotal
    private double subTotalPrice(ArrayList<Pizza> pizzas){
        double subTotal = 0.0;
        for (int i = 0; i < pizzas.size(); i++){
            subTotal += pizzas.get(i).price();
        }
        return subTotal;
    }
}