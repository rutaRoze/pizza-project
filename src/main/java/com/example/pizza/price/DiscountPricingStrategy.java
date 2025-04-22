package com.example.pizza.price;

import com.example.pizza.model.Pizza;

public class DiscountPricingStrategy implements PricingStrategy {
    private final double discountPercentage;

    public DiscountPricingStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(Pizza pizza) {
        double totalCost = pizza.getCost();

        return totalCost - (totalCost * discountPercentage / 100);
    }

    @Override
    public String getPricingMessage() {
        return String.format("Discount of %.0f%% applied!", discountPercentage);
    }
}
