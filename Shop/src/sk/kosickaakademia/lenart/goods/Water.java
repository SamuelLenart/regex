package sk.kosickaakademia.lenart.goods;

import sk.kosickaakademia.lenart.Item;
import sk.kosickaakademia.lenart.Util.util;

public class Water extends Item implements CountItem{
    private int count;
    public Water(double price, String name, int count){
        super(price, name);
        this.count=count;
    }

    @Override
    public int getCount(){
        return count;
    }

    @Override
    public void setCount(int c) {
        this.count=c;
    }

    @Override
    public double getItemPrice(){
        return getPrice()*count;
    }

    @Override
    public String toString() {
        return "Water:=" +getName()+" , Price per piece: "+getCount()+" , count"+count+" , Price: "+ util.formatPrice(getItemPrice());

    }
}
