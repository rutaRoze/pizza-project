package com.example.pizza.price;

import com.example.pizza.model.Pizza;

public class StandardPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Pizza pizza) {
        return pizza.getCost();
    }

    @Override
    public String getPricingMessage() {
        return "Standard price";
    }
}
