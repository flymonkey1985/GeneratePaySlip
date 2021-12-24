package com.company.entity;

import com.company.tools.CurrencyUtil;

public class PaySlip {
    private String name;
    private double monthlyIncome;
    private double monthlyTax;
    private double monthlyNetIncome;

    public PaySlip(String name, double monthlyIncome, double monthlyTax){
        this.name = name;
        this.monthlyIncome = monthlyIncome;
        this.monthlyTax = monthlyTax;
        this.monthlyNetIncome = this.monthlyIncome - this.monthlyTax;
    }



   void printPaySlip(){
       System.out.println("Monthly Payslip for: "+this.name);
       System.out.println("Gross Monthly Income: "+ CurrencyUtil.displayValueAsCurrency(this.monthlyIncome));
       System.out.println("Monthly Income Tax: "+CurrencyUtil.displayValueAsCurrency(this.monthlyTax));
       System.out.println("Net Monthly Income: "+CurrencyUtil.displayValueAsCurrency(this.monthlyNetIncome));
   }


}
