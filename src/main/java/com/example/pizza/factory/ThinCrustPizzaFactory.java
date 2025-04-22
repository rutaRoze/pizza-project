package com.example.pizza.factory;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.ThinCrustPizza;

public class ThinCrustPizzaFactory implements PizzaFactory {

    @Override
    public Pizza createPizza() {
        return new ThinCrustPizza();
    }
}
