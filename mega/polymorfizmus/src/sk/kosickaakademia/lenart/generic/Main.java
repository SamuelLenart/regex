package sk.kosickaakademia.lenart.generic;


import java.util.Date;

public class Main {
    public static void main(String[] args) {

        AlgorithmRNG algS = new AlgorithmRNG();
        Algorithm alg = new Algorithm();
        System.out.println(alg.add(15, 28));
        System.out.println(alg.add(15.4, 28.5));
        System.out.println(algS.random(15, 13.5, "Sup"));

        System.out.println(new AlgorithmRNG<String>().random("Jaro", "Samo", "Jana"));

        new AlgorithmRNG<String>().checkType("Mirko");
        new AlgorithmRNG<Date>().checkType(new Date());
        new AlgorithmRNG<Integer>().checkType(38);
        new AlgorithmRNG<>().checkType(69);
    }
}
