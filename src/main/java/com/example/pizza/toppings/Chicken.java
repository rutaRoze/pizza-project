package com.example.pizza.toppings;

import com.example.pizza.model.Pizza;

public class Chicken extends ToppingDecorator {

    public Chicken(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Chicken";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}
