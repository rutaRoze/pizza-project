package com.example.pizza;

import com.example.pizza.command.AddCheeseCommand;
import com.example.pizza.command.AddChickenCommand;
import com.example.pizza.command.AddMushroomsCommand;
import com.example.pizza.command.ToppingInvoker;
import com.example.pizza.factory.PizzaFactory;
import com.example.pizza.factory.ThickCrustPizzaFactory;
import com.example.pizza.factory.ThinCrustPizzaFactory;
import com.example.pizza.model.Pizza;
import com.example.pizza.observer.ClientObserver;
import com.example.pizza.observer.KitchenObserver;
import com.example.pizza.observer.OrderEvent;
import com.example.pizza.observer.OrderStatus;
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

        //Set up observers
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.registerObserver(OrderEvent.CREATED, new KitchenObserver());
        orderStatus.registerObserver(OrderEvent.COMPLETED, new ClientObserver());

        //Choose pizza base
        PizzaFactory factory = random.nextBoolean()
                ? new ThinCrustPizzaFactory()
                : new ThickCrustPizzaFactory();

        Pizza basePizza = factory.createPizza();

        System.out.println("Base: " + basePizza.getDescription() + " - €" + basePizza.getCost());

        //Choose pizza toppings
        ToppingInvoker invoker = new ToppingInvoker();
        if (random.nextBoolean()) invoker.addCommand(new AddCheeseCommand());
        if (random.nextBoolean()) invoker.addCommand(new AddMushroomsCommand());
        if (random.nextBoolean()) invoker.addCommand(new AddChickenCommand());

        //Execute chosen topping commands
        Pizza pizzaWithTops = invoker.executeAll(basePizza);

        orderStatus.notifyObservers(OrderEvent.CREATED, pizzaWithTops.getDescription());
        System.out.printf("Total Cost before pricing strategy: €%.2f%n", pizzaWithTops.getCost());

        //Remove topping
        invoker.removeLastCommand();
        pizzaWithTops = invoker.executeAll(basePizza);
        orderStatus.notifyObservers(OrderEvent.CREATED, "UPDATED - " + pizzaWithTops.getDescription());
        System.out.printf("PIZZA MODIFIED - Total Cost before pricing strategy: €%.2f%n", pizzaWithTops.getCost());

        //Choose pricing policy
        PricingStrategy pricingStrategy = random.nextBoolean()
                ? new StandardPricingStrategy()
                : new DiscountPricingStrategy(10.0);

        //Apply pricing strategy
        double finalPrice = pricingStrategy.calculatePrice(pizzaWithTops);
        String message = pricingStrategy.getPricingMessage();

        orderStatus.notifyObservers(OrderEvent.COMPLETED, "");

        System.out.println("Final Pizza: " + pizzaWithTops.getDescription());
        System.out.printf("Total Cost: €%.2f, %s%n", finalPrice, message);
    }
}
