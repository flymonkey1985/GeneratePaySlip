package com.company.entity;

import com.company.exception.PaySlipException;
import com.company.tools.CurrencyUtil;

import static com.company.constant.Constant.*;

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
        valid();
    }

    /**
     * It is method to valid payslip parameters
     * @throws PaySlipException throws the exception if monthly income, monthly tax, monthly net income is negative
     */
    private void valid() throws PaySlipException {
        if(this.monthlyIncome < 0){
            throw new PaySlipException(MONTHLY_INCOME_IS_NEGATIVE + this.monthlyIncome);
        }
        if(this.monthlyTax < 0) {
            throw new PaySlipException(MONTHLY_TAX_IS_NEGATIVE + this.monthlyTax);
        }
        if(this.monthlyNetIncome < 0) {
            throw new PaySlipException(MONTHLY_NET_INCOME_IS_NEGATIVE + this.monthlyNetIncome);
        }
    }

    /**
     * The method is used to print payslip details
     */

   void printPaySlip(){
       System.out.println("Monthly Payslip for: "+this.name);
       System.out.println("Gross Monthly Income: "+ CurrencyUtil.displayValueAsCurrency(this.monthlyIncome));
       System.out.println("Monthly Income Tax: "+CurrencyUtil.displayValueAsCurrency(this.monthlyTax));
       System.out.println("Net Monthly Income: "+CurrencyUtil.displayValueAsCurrency(this.monthlyNetIncome));
   }


}
