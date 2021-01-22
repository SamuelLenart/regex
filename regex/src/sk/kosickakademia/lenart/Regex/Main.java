package sk.kosickakademia.lenart.Regex;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("resources/money.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String data;
        while ((data=br.readLine()) != null) {
            System.out.println(data);
        }
    }
}
