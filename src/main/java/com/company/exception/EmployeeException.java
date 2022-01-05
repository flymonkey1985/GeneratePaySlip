package com.company.exception;

public class EmployeeException extends RuntimeException{
    private String message;

    public EmployeeException(String message){
        super(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
