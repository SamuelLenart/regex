package sk.kosickaakademia.lenart.stack;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;

public class Stack<R> {
    private int capacity;
    private List<R> array;

    public Stack(int c) {
        this.capacity=c;
        array=new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize(){
        return array.size();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public boolean isFull(){
        return capacity==array.size();
    }

    public void push(R value) throws StackException{
        if(isFull()){
            throw new StackException("This stack is full!");
        }else
            array.add(value);
    }

    public void pop() throws StackException{
        if(isEmpty()){
            throw new StackException("This stack is empty!");
        }else
            array.remove(array.size()-1);
    }

    public R top(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        else
            return array.get(array.size()-1);
    }
    public void print(){
        for(R t:array)
            System.out.println(t+" ");
    }

    public void clear(){
        array.clear();
    }
}
