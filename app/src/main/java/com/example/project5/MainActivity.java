package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView phoneNumber;
    ImageButton orderDeluxe, orderHawaiian, orderPepperoni;

    StoreOrders storeOrders = new StoreOrders();
    Order currentOrder = new Order();

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
        intent.putExtra("current order", currentOrder);

        startActivity(intent);
    }

    protected void orderHawaiian(View view){
        Intent intent = new Intent(this, pizzaOrderView.class);
        intent.putExtra("pizza type", "Hawaiian");
        intent.putExtra("current order", currentOrder);

        startActivity(intent);
    }

    protected void orderPepperoni(View view){
        Intent intent = new Intent(this, pizzaOrderView.class);
        intent.putExtra("pizza type", "Pepperoni");
        intent.putExtra("current order", currentOrder);

        startActivity(intent);
    }

    protected void viewCurrentOrder(View view){
        Intent intent = new Intent(this, currentOrderView.class);
        if(validate(phoneNumber.getText().toString())){
            intent.putExtra("phone", phoneNumber.getText());
            intent.putExtra("cart", currentOrder);
            intent.putExtra("store orders", storeOrders);
            startActivity(intent);
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Please enter a valid phone number";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * Validates a phone number making sure it is a 10-digit number
     * @param number - the number to validate
     * @return true if valid, false if not
     */
    public static boolean validate(String number){
        try{
            Long.parseLong(number);
            return number.length() == 10; // phone number must be 10 digits long
        }catch(NumberFormatException e){
            return false; // not a valid phone number with 10 digits
        }
    }


    protected void viewStoreOrder(View view){

    }
}