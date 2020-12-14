package sk.kosickaakademia.lenart.service;

import sk.kosickaakademia.lenart.Item;

public class Delivery extends Item implements Service{

    public Delivery(double price) {
        super(price, "delivery");
    }

    @Override
    public double getItemPrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return "Delivery, Price: "+getPrice();
    }
}
