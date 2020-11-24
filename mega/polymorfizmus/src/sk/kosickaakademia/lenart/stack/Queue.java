package sk.kosickaakademia.lenart.stack;

import java.util.ArrayList;
import java.util.List;

public class Queue<R> {
        private int capacity;
        private List<R> array;

        public Queue(int c){
        this.capacity = c;
        array = new ArrayList<>();
    }

    public int getCapacity(){
        return capacity;
    }

    public int getSize(){
        return array.size();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public boolean isFull(){
        return capacity == array.size();
    }

    public void enqueue(R value){
        if (isFull())
            System.out.println("This queue is full!");
        else
            array.add(value);
    }

    public void dequeue(){
        if (isEmpty())
            System.out.println("This queue is empty!");
        else
            array.remove(array.size()-capacity);
    }

    public R front(){
        if (isEmpty()){
            System.out.println("This queue is empty!");
            return null;
        }
        else
            return array.get(0);
    }

    public void print(){
        for (R temp : array){
            System.out.print(temp + "  ");
        }
        System.out.println();
    }

    public void clear(){
        array.clear();
    }

}
