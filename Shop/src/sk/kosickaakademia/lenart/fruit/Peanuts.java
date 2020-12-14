package sk.kosickaakademia.lenart.fruit;

import sk.kosickaakademia.lenart.Item;
import sk.kosickaakademia.lenart.Util.util;
import sk.kosickaakademia.lenart.fruit.WeightItem;

public class Peanuts extends Item implements WeightItem {
    private double weight;

    public Peanuts(double price, String name, double weight) {
        super(price, name);
        this.weight=weight;
    }
    @Override
    public double getWeight(){
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getItemPrice(){
        return weight*getPrice();
    }
    @Override
    public String toString() {
        return "Peanuts: " +getName()+" , Price per kg: " +getPrice()+", weight"+weight+" , Price: "+ util.formatPrice(getItemPrice());
    }
}
