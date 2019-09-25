package com.aks.Exceptions;


public class CustomGenericException extends RuntimeException {
    public CustomGenericException(String message, Throwable cause){
        super(cause.getMessage());
    }
}
