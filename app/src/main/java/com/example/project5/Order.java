package com.example.project5;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Order class that holds the pizzas, phone number, and order total for a pizza order
 * @author Wesam Saleh, Najibullah Assadullah
 */

public class Order implements Serializable {
    protected ArrayList<Pizza> pizzas;
    String phoneNumber;
    double orderTotal;

    /**
     * Constructor for order class
     */
    public Order(){
        this.pizzas = new ArrayList<Pizza>();
        this.phoneNumber = "";
        this.orderTotal = 0;
    }
}
