package sk.kosickakademia.lenart.Regex;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public boolean checkValue(String text) {
        if(text == null || text.equalsIgnoreCase(""))
            return false;
            String pattern = "(.*)(\\d+)(x*)";

        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(text);
        if(m.matches()){
            return true;
        }

        return false;
    }
}
