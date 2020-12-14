package sk.kosickaakademia.lenart.coupon;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;
import java.util.Scanner;


public class Reading {
    private static String fileName = "rsrc/coupon.txt";

    public static List<Coupons> getListOfCouponsFromFile(){
        List<Coupons> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] array = data.split(" ");
                Coupons newCoupon = new Coupons(array[0],Integer.parseInt(array[1]));
                list.add(newCoupon);
            }
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void updateCoupons(List<Coupons> list){
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            for(Coupons temp:list){
                fw.write(temp.getCode()+" "+temp.getValue()+"\n");
            }
            fw.flush();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}