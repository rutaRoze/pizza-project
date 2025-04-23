package com.example.pizza.observer;

public class ClientObserver implements OrderObserver {

    @Override
    public void update(String status) {
        System.out.println("Your order is complete: " + status);
    }
}
