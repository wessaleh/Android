package com.example.project5;

/**
 * Pizza Maker class
 * @author Wesam Saleh, Najibullah Assadullah
 */

public class PizzaMaker {

    /**
     * Creates an instance of pizza
     * @param flavor - the flavor of pizza
     * @return the pizza
     */
    public static Pizza createPizza(String flavor) {
        if (flavor.equals("Hawaiian")) {
            return new Hawaiian();
        }

        if (flavor.equals("Deluxe")) {
            return new Deluxe();
        }

        if (flavor.equals("Pepperoni")) {
            return new Pepperoni();
        }

        return null;
    }
}
