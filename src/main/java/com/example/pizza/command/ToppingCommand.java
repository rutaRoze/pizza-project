package com.example.pizza.command;

import com.example.pizza.model.Pizza;

public interface ToppingCommand {
    Pizza execute(Pizza pizza);
}
