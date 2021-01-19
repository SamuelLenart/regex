package sk.kosickakademia.lenart.Regex;

import java.util.Locale;

public class NoRegex {
    public boolean isValidSPZ(String text){
        if(text == null)
            return false;

        text = text.toUpperCase().trim();
        if(text.length()!=7)
            return false;

        for(int i = 0; i <= 1; i++)
            if(!Character.isLetter(text.charAt(i)))
                return false;

        for(int i = 0; i <= 6; i++)
            if(!Character.isLetterOrDigit(text.charAt(i)))
                return false;

            return true;
    }

    public boolean isValidOP(String text){
        if(text == null)
            return false;

        text = text.toUpperCase().trim();
        if(text.length()!=8)
            return false;

        for(int i = 0; i <= 1; i++)
            if(!Character.isLetter(text.charAt(i)))
                return false;

        for(int i = 0; i <= 7; i++)
            if(!Character.isLetterOrDigit(text.charAt(i)))
                return false;

        return true;
    }
}
