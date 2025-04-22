package com.example.pizza.toppings;

import com.example.pizza.model.Pizza;

public abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract String getDescription();
}
