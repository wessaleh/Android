package com.example.project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Store Orders class for keeping track of orders and exporting them
 * @author Wesam Saleh, Najibullah Assadullah
 */

public class StoreOrders implements Serializable {
    protected ArrayList<Order> orders;

    /**
     * Constructor for store orders class
     */
    public StoreOrders(){
        this.orders = new ArrayList<>();
    }
}
