package com.company.tools;

import java.util.regex.Pattern;

public class ValidateUtil {
    public static boolean validateName(String name){
        return Pattern.matches("[^0-9]+",name);

    }
}
