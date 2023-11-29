package com.example.clientmanagement.exception;

public class CustomerNotFoundException extends RuntimeException{
    String message;
    public CustomerNotFoundException() {
    }
    public CustomerNotFoundException(String msg) {
        super(msg);
        this.message= msg;
    }

}
