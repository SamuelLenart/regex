package sk.kosickakademia.lenart;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(3);
        try {
            stack.push(45);
            stack.push(9);
            stack.push(33);
            stack.push(77);
            stack.pop();
            stack.pop();
            stack.pop();
            stack.print();
        }catch(exception ex) {
            ex.printStackTrace();
        }
    }
}