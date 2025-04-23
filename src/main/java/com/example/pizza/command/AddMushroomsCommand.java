package com.example.pizza.command;

import com.example.pizza.model.Pizza;
import com.example.pizza.toppings.Mushrooms;

public class AddMushroomsCommand implements ToppingCommand {
    @Override
    public Pizza execute(Pizza pizza) {

        return new Mushrooms(pizza);
    }
}
