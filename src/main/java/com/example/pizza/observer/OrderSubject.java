package com.example.pizza.observer;

public interface OrderSubject {

    void registerObserver(OrderEvent event, OrderObserver observer);
    void notifyObservers(OrderEvent event, String details);
}
