package com.example.pizza;

import com.example.pizza.factory.PizzaFactory;
import com.example.pizza.factory.ThickCrustPizzaFactory;
import com.example.pizza.factory.ThinCrustPizzaFactory;
import com.example.pizza.model.Pizza;
import com.example.pizza.price.DiscountPricingStrategy;
import com.example.pizza.price.PricingStrategy;
import com.example.pizza.price.StandardPricingStrategy;
import com.example.pizza.toppings.Cheese;
import com.example.pizza.toppings.Chicken;
import com.example.pizza.toppings.Mushrooms;
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
        if (random.nextBoolean()) pizza = new Cheese(pizza);
        if (random.nextBoolean()) pizza = new Mushrooms(pizza);
        if (random.nextBoolean()) pizza = new Chicken(pizza);

        System.out.println("Final Pizza: " + pizza.getDescription());
        System.out.println("Total Cost: €" + pizza.getCost());

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
