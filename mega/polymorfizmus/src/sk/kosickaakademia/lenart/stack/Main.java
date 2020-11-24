package sk.kosickaakademia.lenart.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> zas = new Stack<>(3);
        try {
            zas.push(45);
            zas.push(9);
            zas.push(33);
            zas.pop();
            zas.print();
        }catch(StackException ex) {
            ex.printStackTrace();
        }
    }
}
