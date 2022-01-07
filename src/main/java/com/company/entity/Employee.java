package com.company.entity;


import com.company.exception.EmployeeException;
import com.company.tools.CurrencyUtil;
import com.company.tools.TaxCalculator;
import com.company.tools.ValidateUtil;

import static com.company.constant.Constant.EMPLOYEE_HAS_INVALID_ANNUAL_SALARY;
import static com.company.constant.Constant.EMPLOYEE_HAS_INVALID_NAME;

public class Employee {
    private String name;
    private double annualSalary;


    public Employee(String name, double annualSalary) {
        this.name = name;
        this.annualSalary = annualSalary;
        valid();

    }

    /**
     * It is method to valid employee parameters
     * @throws EmployeeException throws exception if annual salary is negative or name is invalid
     */
    private void valid() throws EmployeeException{
        if(this.annualSalary < 0){
            throw new EmployeeException(EMPLOYEE_HAS_INVALID_ANNUAL_SALARY + annualSalary);
        }
        if(!ValidateUtil.validateName(this.name)){
            throw new EmployeeException(EMPLOYEE_HAS_INVALID_NAME + name);
        }
    }



    /**
     * The method is used to caculate payslip for employee
     * @return Payslip
     */
    public PaySlip caculatePaySlip(){
        double monthlyIncome = CurrencyUtil.convertValueWithScale(annualSalary/12, 2);
        double monthlyTax = CurrencyUtil.convertValueWithScale(TaxCalculator.calculateMonthlyTax(annualSalary), 2);

        return new PaySlip(name, monthlyIncome, monthlyTax);
    }



    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = " + name +
                ", annualSalary = " + annualSalary+
                "}";

    }


}
