package sk.kosickaakademia.lenart.Util;

public class util {
    public static double convertEurotoSKK(double value){
        return formatPrice(value * 30.126);
    }

    public static double formatPrice(double price){
        double result = (double) Math.round(price * 100)/100;
        return result;
    }
}

