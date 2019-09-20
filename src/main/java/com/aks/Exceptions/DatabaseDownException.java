package com.aks.Exceptions;

public class DatabaseDownException extends RuntimeException {
    public DatabaseDownException(String msg) {
        super(msg);
    }
}
