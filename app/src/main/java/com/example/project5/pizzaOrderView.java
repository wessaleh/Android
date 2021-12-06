package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class pizzaOrderView extends AppCompatActivity {

    Button addToOrder;
    Spinner pizzaSize;
    CheckBox chicken;
    CheckBox beef;
    CheckBox ham;
    CheckBox pineapples;
    CheckBox cheese;
    CheckBox sausage;
    CheckBox greenPepper;
    CheckBox pepperoni;
    CheckBox mushrooms;
    TextView pizzaLabel;
    ImageView pizzaImage;
    Pizza pizza;

    final int MAX_TOPPINGS = 7;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_order_view);

        addToOrder = findViewById(R.id.addToOrder);
        pizzaSize = findViewById(R.id.pizzaSize);
        chicken = findViewById(R.id.chicken);
        beef = findViewById(R.id.beef);
        ham = findViewById(R.id.ham);
        pineapples = findViewById(R.id.pineapples);
        cheese = findViewById(R.id.cheese);
        ham = findViewById(R.id.ham);
        sausage = findViewById(R.id.sausage);
        greenPepper = findViewById(R.id.greenPeppers);
        pepperoni = findViewById(R.id.pepperoni);
        mushrooms = findViewById(R.id.mushrooms);
        pizzaLabel = findViewById(R.id.pizzaLabel);
        pizzaImage = findViewById(R.id.pizzaPicture);

        Intent intent = getIntent();
        String pizzaType = intent.getExtras().get("pizza type").toString();
        pizza = PizzaMaker.createPizza(pizzaType);
        pizzaLabel.setText(pizzaType);

        addToOrder.setOnClickListener(this::addToOrder);
    }

    public void addToOrder(View view) {
        checkToppings(pizza);
        checkSize(pizza);

        Intent intent = getIntent();
        Order currentOrder = (Order) intent.getExtras().get("current order");
        currentOrder.pizzas.add(pizza);
    }

    private void checkToppings(Pizza pizza){
        Toast toast = Toast.makeText(getApplicationContext(), "Maximum number of toppings is 7", Toast.LENGTH_SHORT);
        if (chicken.isChecked()){
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        }
        if (beef.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        if (ham.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        if (pineapples.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        if (cheese.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        if (sausage.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        if (greenPepper.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        if (pepperoni.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        if (mushrooms.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
    }

    private void checkSize(Pizza pizza){
        if (pizzaSize.getSelectedItem().toString().equals("Small")){
            pizza.size = Size.Small;
        }
        if (pizzaSize.getSelectedItem().toString().equals("Medium")){
            pizza.size = Size.Medium;
        }
        if (pizzaSize.getSelectedItem().toString().equals("Large")){
            pizza.size = Size.Large;
        }
    }

}