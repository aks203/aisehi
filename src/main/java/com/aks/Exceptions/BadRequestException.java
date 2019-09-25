package com.aks.Exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg){
        super(msg);
    }
}
