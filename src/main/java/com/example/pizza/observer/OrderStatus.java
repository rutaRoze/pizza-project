package com.example.pizza.observer;

import java.util.HashMap;
import java.util.Map;

public class OrderStatus implements OrderSubject {

    private final Map<OrderEvent, OrderObserver> observers = new HashMap<>();

    @Override
    public void registerObserver(OrderEvent event, OrderObserver observer) {
        observers.put(event, observer);
    }

    @Override
    public void notifyObservers(OrderEvent event, String details) {
        OrderObserver observer = observers.get(event);
        if (observer != null) {
            observer.update(details);
        }
    }
}
