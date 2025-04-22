package com.example.pizza.model;

public class ThickCrustPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Thick Crust Pizza";
    }

    @Override
    public double getCost() {
        return 6.00;
    }
}
