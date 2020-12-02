import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File a = new File("resources\\a.txt");
        File b = new File("resources\\b.txt");
        ArrayList<Integer> listA = getSet(a);
        ArrayList<Integer> listB = getSet(b);
        ArrayList<Integer> c = getAll(listA, listB);

        aNotInB(listA, listB); //1.
        bNotInA(listA, listB); //2.

        makeAll(c); //3.

        int[] sorted = sort(c);
        for (Integer temp : sorted) //4.
            System.out.println(temp);
    }
    private static ArrayList<Integer> getSet(File a){
        ArrayList<Integer> listA = new ArrayList<>();
        try {
            FileReader fr = new FileReader(a);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            String num = "";
            int count = 0;
            while ((line=reader.readLine()) != null){
                for (int i = 0; i < line.length(); i++){
                    char z = line.charAt(i);
                    if (z >= '0' && z <= '9'){
                        num += z;
                    }
                    if (z == 32 && !num.equals(""))
                        listA.add(Integer.parseInt(num));
                    if (z == 32){
                        num = "";
                    }
                }
                if (!num.equals(""))
                    listA.add(Integer.parseInt(num));
                num = "";
            }
            fr.close();
        }catch (IOException ex){}
        return listA;
    }

    private static void aNotInB(ArrayList<Integer> a, ArrayList<Integer> b){
        System.out.println("A not in B: ");
        for (Integer intA : a)
            if (b.contains(intA));
            else
                System.out.print(intA + " ");
        System.out.println();
    }

    private static void bNotInA(ArrayList<Integer> a, ArrayList<Integer> b){
        System.out.println("B not in A: ");
        for (Integer intB : b)
            if (a.contains(intB));
            else
                System.out.print(intB + " ");
        System.out.println();
    }

    private static ArrayList<Integer> getAll(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> c = new ArrayList<>();
        for (Integer intA : a)
            if (!c.contains(intA))
                c.add(intA);
        for (Integer intB : b)
            if (!c.contains(intB))
                c.add(intB);
        return c;
    }

    private  static void makeAll(ArrayList<Integer> c){
        try {
            File file = new File("resource\\c.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            for (Integer intC : c)
                fw.write(intC + "\n");
            fw.close();
        }catch (IOException ex){}
    }

    private static int[] sort(ArrayList<Integer> c){
        int[] arrayC = new int[c.size()];
        int i = 0;
        for (Integer intC : c){
            arrayC[i++] = intC;
        }
        int temp;
        for (int j = 0; j < arrayC.length; j++)
            for (int k = 1; k < (arrayC.length); k++)
                if (arrayC[k-1] > arrayC[k]) {
                    temp = arrayC[k-1];
                    arrayC[k-1] = arrayC[k];
                    arrayC[k] = temp;
                }
        return arrayC;
    }

}