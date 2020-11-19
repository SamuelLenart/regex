package sk.kosickaakademia.lenart.hashset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*Set<Integer> mnozina = new HashSet<>();
        mnozina.add(45);
        mnozina.add(22);
        mnozina.add(45);
        mnozina.add(18);
        mnozina.add(45);
        for(Integer temp : mnozina){
            System.out.println(temp);
        }*/
        printHowmanyNames();
    }
    public static void printHowmanyNames(){
        HashSet<String> set = new HashSet<>();
        try {
            FileReader fr = new FileReader("resources/names.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                set.add(line);
            }
            fr.close();
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
        printCount((HashSet) set);
        System.out.println();
        printEveryone((HashSet) set);
    }
    private static void printCount(HashSet set){
        System.out.println("Numbers of names are: " +set.size());
    }
    private static void printEveryone(HashSet<String> set){
        for (String temp : set){
            System.out.println(temp);
        }
    }
}
