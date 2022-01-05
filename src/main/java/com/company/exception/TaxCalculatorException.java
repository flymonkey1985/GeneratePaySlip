package com.company.exception;

public class TaxCalculatorException extends RuntimeException{

    private String message;

    public TaxCalculatorException(String message){
        super(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
