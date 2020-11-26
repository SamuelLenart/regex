package sk.kosickaakademia.lenart.generic;

import java.util.Random;

public class AlgorithmRNG<R> {
    public R random(R a, R b, R c){


        int index = new Random().nextInt(3);
        switch (index){
            case 0: return a;
            case 1: return b;
            default: return c;
        }
    }

    public void checkType(R obj) {
        if (obj instanceof Number)
            System.out.println("It's a number");
        else if (obj instanceof String)
            System.out.println("It's a string");
        else
            System.out.println("Unknown type: "+obj.getClass());
    }
}
