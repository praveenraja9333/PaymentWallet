package com.vrp.system.paymentsystem.paymentwallet.exceptions;

public class DuplicateTransactionException extends RuntimeException{
    public DuplicateTransactionException(String message){
        super(message);
    }
}
