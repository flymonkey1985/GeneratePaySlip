package com.company.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;


public class CurrencyUtil {
    /**
     * The method is used to convert the input value
     * with the decimal place nominated
     * @param input it is the input value
     * @param scale it is the decimal place nominated
     * @return convertedValue
     */
    public static double convertValueWithScale(double input, int scale){
        BigDecimal value=new BigDecimal(input).setScale(scale, RoundingMode.HALF_UP);
        return value.doubleValue();
    }

    /**
     * The method is used to display input as currency
     * @param value it is the input
     * @return the currency value
     */
    public static String displayValueAsCurrency(double value){
        Locale au = new Locale("en", "AU");
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(au);
        return dollarFormat.format(value);
    }
}
