package com.example.pizza.toppings;

import com.example.pizza.model.Pizza;

public class Mushrooms extends ToppingDecorator {

    public Mushrooms(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 0.8;
    }
}
