package com.example.pizza.observer;

public class KitchenObserver implements OrderObserver {

    @Override
    public void update(String details) {
        System.out.println("New order placed: " + details);
    }
}
