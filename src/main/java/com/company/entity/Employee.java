package com.company.entity;


import com.company.tools.CurrencyUtil;
import com.company.tools.TaxCalculator;

public class Employee {
    private String name;
    private double annualSalary;
    private PaySlip paySlip;

    public Employee(String name, double annualSalary) {
        this.name = name;
        this.annualSalary = annualSalary;
        initPaySlip(this.name, this.annualSalary);
    }


    private void initPaySlip(String name, double annualSalary){
        double monthlyIncome = CurrencyUtil.convertValueWithScale(annualSalary/12, 2);
        double monthlyTax = CurrencyUtil.convertValueWithScale(TaxCalculator.calculateMonthlyTax(annualSalary), 2);

        this.paySlip = new PaySlip(name, monthlyIncome, monthlyTax);
    }

    /**
     * The method is used to generate pay slip for employee
     */
    public void generatePaySlip(){
        this.paySlip.printPaySlip();
    }

    public String getName(){
        return this.name;
    }


}
