package com.example.pizza.command;

import com.example.pizza.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class ToppingInvoker {

    private final List<ToppingCommand> commands = new ArrayList<>();

    public void addCommand(ToppingCommand command) {
        commands.add(command);
    }

    public void removeLastCommand() {
        if (!commands.isEmpty()) {
            commands.removeLast();
        }
    }

    public Pizza executeAll(Pizza pizza) {
        for (ToppingCommand command : commands) {
            pizza = command.execute(pizza);
        }
        return pizza;
    }
}
