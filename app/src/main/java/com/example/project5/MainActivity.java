package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView phoneNumber;
    ImageButton orderDeluxe, orderHawaiian, orderPepperoni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.phoneNumber);

        orderDeluxe = findViewById(R.id.deluxePicture);
        orderDeluxe.setOnClickListener(this::orderDeluxe);

        orderHawaiian = findViewById(R.id.hawaiianPicture);
        orderHawaiian.setOnClickListener(this::orderHawaiian);

        orderPepperoni = findViewById(R.id.pepperoniPicture);
        orderPepperoni.setOnClickListener(this::orderPepperoni);
    }

    protected void orderDeluxe(View view){
        Intent intent = new Intent(this, pizzaOrderView.class);

        intent.putExtra("pizza type", "Deluxe");
        startActivity(intent);
    }

    protected void orderHawaiian(View view){
        Intent intent = new Intent(this, pizzaOrderView.class);
        intent.putExtra("pizza type", "Hawaiian");

        startActivity(intent);
    }

    protected void orderPepperoni(View view){
        Intent intent = new Intent(this, pizzaOrderView.class);
        intent.putExtra("pizza type", "Pepperoni");

        startActivity(intent);
    }

    protected void viewCurrentOrder(View view){

    }

    protected void viewStoreOrder(View view){

    }
}