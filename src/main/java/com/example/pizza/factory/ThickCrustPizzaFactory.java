package com.example.pizza.factory;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.ThickCrustPizza;

public class ThickCrustPizzaFactory implements PizzaFactory {

    @Override
    public Pizza createPizza() {
        return new ThickCrustPizza();
    }
}
