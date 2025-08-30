package com.ecomm.plugback.Exceptions;

public class OutOfStockException extends RuntimeException {
    
    public OutOfStockException(String message){
        super(message);
    }
}
