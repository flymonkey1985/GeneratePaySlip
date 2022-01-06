package com.company.tools;

import com.company.entity.Tax;
import com.company.exception.TaxCalculatorException;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
    static final double TWENTY_THOUSAND_TIE = 20000d;
    static final double FORTY_THOUSAND_TIE = 40000d;
    static final double EIGHTY_THOUSAND_TIE = 80000d;
    static final double ONE_EIGHTY_THOUSAND_TIE = 180000d;
    static List<Tax> taxList;
    //populate tax list
    static {
        taxList = new ArrayList<>();
        Tax item_for_twenty_thousand = new Tax(TWENTY_THOUSAND_TIE, 0, 0, 0);
        Tax item_for_forty_thousand = new Tax(FORTY_THOUSAND_TIE, TWENTY_THOUSAND_TIE, 0.1, 0);
        Tax item_for_eighty_thousand = new Tax(EIGHTY_THOUSAND_TIE, FORTY_THOUSAND_TIE, 0.2, 2000);
        Tax item_for_one_eighty_thousand = new Tax(ONE_EIGHTY_THOUSAND_TIE, EIGHTY_THOUSAND_TIE, 0.3, 10000);
        Tax item_for_above_one_eighty_thousand = new Tax(Double.MAX_VALUE, ONE_EIGHTY_THOUSAND_TIE, 0.4, 40000);

        taxList.add(item_for_twenty_thousand);
        taxList.add(item_for_forty_thousand);
        taxList.add(item_for_eighty_thousand);
        taxList.add(item_for_one_eighty_thousand);
        taxList.add(item_for_above_one_eighty_thousand);
    }



    /**
     * The method is used for calculating the monthly tax
     * based on the annual salary
     * @param annualSalary it is annual salary
     * @return monthlyTax
     */
    public static double calculateMonthlyTax(double annualSalary)
            throws TaxCalculatorException {
        if(annualSalary < 0){
            throw new TaxCalculatorException("Invalid annual salary : "+annualSalary);
        }
        double tax = 0d;
        if(annualSalary > TWENTY_THOUSAND_TIE){
            for (Tax item : taxList) {
                if (annualSalary > item.getMin() && annualSalary <= item.getMax()){
                    tax = (item.getBaseTax() + (annualSalary-item.getMin())*item.getTaxRate()) / 12;
                }
            }
        }

        return CurrencyUtil.convertValueWithScale(tax, 2);
    }
}
