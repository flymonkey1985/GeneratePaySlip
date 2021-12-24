package com.company.tools;

public class TaxCalculator {
    static final double TWENTY_THOUSAND_TIE = 20000d;
    static final double FORTY_THOUSAND_TIE = 40000d;
    static final double EIGHTY_THOUSAND_TIE = 80000d;
    static final double ONE_EIGHTY_THOUSAND_TIE = 180000d;

    /**
     * The method is used for calculating the monthly tax
     * based on the annual salary
     * @param annualSalary it is annual salary
     * @return monthlyTax
     */
    public static double calculateMonthlyTax(double annualSalary) {
        if(annualSalary < 0){
            throw new IllegalArgumentException("Invalid annual salary : "+annualSalary);
        }
        double tax = 0d;
        if (annualSalary <= TWENTY_THOUSAND_TIE) {

        } else if (annualSalary > TWENTY_THOUSAND_TIE && annualSalary <= FORTY_THOUSAND_TIE) {
            tax = ((annualSalary - TWENTY_THOUSAND_TIE) * 0.1) / 12;

        } else if (annualSalary > FORTY_THOUSAND_TIE && annualSalary <= EIGHTY_THOUSAND_TIE) {
            tax =  ((annualSalary - FORTY_THOUSAND_TIE) * 0.2
                    + (FORTY_THOUSAND_TIE - TWENTY_THOUSAND_TIE) * 0.1) / 12;

        } else if (annualSalary > EIGHTY_THOUSAND_TIE && annualSalary <= ONE_EIGHTY_THOUSAND_TIE) {
            tax = ((annualSalary - EIGHTY_THOUSAND_TIE) * 0.3
                    + (EIGHTY_THOUSAND_TIE - FORTY_THOUSAND_TIE) * 0.2
                    + (FORTY_THOUSAND_TIE - TWENTY_THOUSAND_TIE) * 0.1) / 12;
        } else {
            tax = ((annualSalary - ONE_EIGHTY_THOUSAND_TIE) * 0.4
                    + (ONE_EIGHTY_THOUSAND_TIE - EIGHTY_THOUSAND_TIE) * 0.3
                    + (EIGHTY_THOUSAND_TIE - FORTY_THOUSAND_TIE) * 0.2
                    + (FORTY_THOUSAND_TIE - TWENTY_THOUSAND_TIE) * 0.1) / 12;
        }

        return CurrencyUtil.convertValueWithScale(tax, 2);
    }
}
