package sk.kosickaakademia.lenart.cart;

import sk.kosickaakademia.lenart.Item;
import sk.kosickaakademia.lenart.Util.util;
import sk.kosickaakademia.lenart.fruit.WeightItem;
import sk.kosickaakademia.lenart.goods.CountItem;
import sk.kosickaakademia.lenart.service.Service;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> list;

    public Cart() {
        list = new ArrayList<>();
    }
    public void addItem(Item newItem){
        if(newItem.getPrice()>=0){
            if(newItem instanceof CountItem && ((CountItem) newItem).getCount()>0){
                boolean isAlreatyInCart=false;
                for(Item temp: list){
                    if(temp.getName().equalsIgnoreCase(newItem.getName()) &&
                            temp.getPrice()==newItem.getPrice()){
                        ((CountItem)temp).setCount(((CountItem) temp).getCount() +
                                ((CountItem) newItem).getCount());
                        isAlreatyInCart=true;
                        break;
                    }
                }
                if(isAlreatyInCart==false)
                    list.add(newItem);
            }
            if(newItem instanceof WeightItem && ((WeightItem) newItem).getWeight()>0){
                boolean isAlreatyInCart=false;
                for(Item temp: list){
                    if(temp.getName().equalsIgnoreCase(newItem.getName()) &&
                            temp.getPrice()==newItem.getPrice()){
                        ((WeightItem)temp).setWeight(((WeightItem) temp).getWeight() +
                                ((WeightItem) newItem).getWeight());
                        isAlreatyInCart=true;
                        break;
                    }
                }
                if(isAlreatyInCart==false)
                    list.add(newItem);
            }
            if(newItem instanceof Service){
                list.add(newItem);
            }
        }

    }
    public int getCountOfItemsInCart(){
        return list.size();
    }
    public double getTotalPrice(){
        double total = 0;
        for(Item temp : list){
            total = total + util.formatPrice(temp.getItemPrice());
        }
        return util.formatPrice(total);
    }
    public void printCart(){
        System.out.println("List of items in your cart:");
        for(Item temp : list){
            System.out.println(" -  "+temp.toString());
        }
    }
    public void printAll(){
        printCart();
        System.out.println("----------------------------------------------------------");
        System.out.println("Total price: " + getTotalPrice());
    }
}