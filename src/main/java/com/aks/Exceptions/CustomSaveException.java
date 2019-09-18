package com.aks.Exceptions;

public class CustomSaveException extends RuntimeException {
    public CustomSaveException(String message){
        super(message);
    }
}
