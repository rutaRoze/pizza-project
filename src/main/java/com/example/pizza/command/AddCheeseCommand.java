package com.example.pizza.command;

import com.example.pizza.model.Pizza;
import com.example.pizza.toppings.Cheese;

public class AddCheeseCommand implements ToppingCommand {
    @Override
    public Pizza execute(Pizza pizza) {

        return new Cheese(pizza);
    }
}
