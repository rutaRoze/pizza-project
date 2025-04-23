package com.example.pizza;

import com.example.pizza.command.AddCheeseCommand;
import com.example.pizza.command.AddChickenCommand;
import com.example.pizza.command.AddMushroomsCommand;
import com.example.pizza.command.ToppingInvoker;
import com.example.pizza.factory.PizzaFactory;
import com.example.pizza.factory.ThickCrustPizzaFactory;
import com.example.pizza.factory.ThinCrustPizzaFactory;
import com.example.pizza.model.Pizza;
import com.example.pizza.price.DiscountPricingStrategy;
import com.example.pizza.price.PricingStrategy;
import com.example.pizza.price.StandardPricingStrategy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PizzaRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();

        //Choose pizza base
        PizzaFactory factory = random.nextBoolean()
                ? new ThinCrustPizzaFactory()
                : new ThickCrustPizzaFactory();

        Pizza pizza = factory.createPizza();

        System.out.println("Base: " + pizza.getDescription() + " - €" + pizza.getCost());

        //Choose pizza toppings
        ToppingInvoker invoker = new ToppingInvoker();
        if (random.nextBoolean()) invoker.addCommand(new AddCheeseCommand());
        if (random.nextBoolean()) invoker.addCommand(new AddMushroomsCommand());
        if (random.nextBoolean()) invoker.addCommand(new AddChickenCommand());

        // Execute chosen topping commands
        pizza = invoker.executeAll(pizza);

        System.out.println("Pizza with chosen toppings: " + pizza.getDescription());
        System.out.printf("Total Cost: €%.2f%n", pizza.getCost());

        //Choose pricing policy
        PricingStrategy pricingStrategy;
        if (random.nextBoolean()) {
            pricingStrategy = new StandardPricingStrategy();
        } else {
            pricingStrategy = new DiscountPricingStrategy(10.0);
        }

        // Apply pricing strategy
        double finalPrice = pricingStrategy.calculatePrice(pizza);
        String message = pricingStrategy.getPricingMessage();

        System.out.println("Final Pizza: " + pizza.getDescription());
        System.out.printf("Total Cost: €%.2f, %s%n", finalPrice, message);
    }
}
