package com.example.pizza.command;

import com.example.pizza.model.Pizza;
import com.example.pizza.toppings.Chicken;

public class AddChickenCommand implements ToppingCommand {
    @Override
    public Pizza execute(Pizza pizza) {

        return new Chicken(pizza);
    }
}
