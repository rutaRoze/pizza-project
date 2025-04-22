package com.example.pizza;

import com.example.pizza.factory.PizzaFactory;
import com.example.pizza.factory.ThickCrustPizzaFactory;
import com.example.pizza.factory.ThinCrustPizzaFactory;
import com.example.pizza.model.Pizza;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PizzaRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();

        PizzaFactory factory = random.nextBoolean()
                ? new ThinCrustPizzaFactory()
                : new ThickCrustPizzaFactory();

        Pizza pizza = factory.createPizza();

        System.out.println("Base: " + pizza.getDescription() + " - €" + pizza.getCost());
    }
}
