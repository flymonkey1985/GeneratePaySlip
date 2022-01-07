package com.company.entity;

public class Tax {
    private double max;
    private double min;
    private double taxRate;
    private double baseTax;

    public Tax(double max, double min, double taxRate, double baseTax){
        this.max = max;
        this.min = min;
        this.taxRate = taxRate;
        this.baseTax = baseTax;
    }

    public double getMax(){
        return this.max;
    }

    public double getMin(){
        return this.min;
    }

    public double getTaxRate(){
        return this.taxRate;
    }

    public double getBaseTax(){
        return this.baseTax;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "max = " + this.max +
                ", min = " + this.min +
                ", taxRate = " + this.taxRate +
                ", baseTax = " + this.baseTax +
                "}";
    }
}
