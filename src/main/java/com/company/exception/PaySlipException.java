package com.company.exception;

public class PaySlipException extends RuntimeException{
    private String message;

    public PaySlipException(String message){
        super(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
