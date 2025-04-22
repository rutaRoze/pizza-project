package com.example.pizza.price;

import com.example.pizza.model.Pizza;

public interface PricingStrategy {
    double calculatePrice(Pizza pizza);
    String getPricingMessage();
}
