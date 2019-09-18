package com.aks;

import com.aks.Exceptions.CustomException;
import com.aks.Exceptions.CustomSaveException;
import com.aks.POJO.CustomExceptionPojo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Custom Exception handler method
     * @param exc
     * @return Error in JSON format
     */
    @ExceptionHandler
    public ResponseEntity<CustomExceptionPojo> handleException(CustomException exc){
        CustomExceptionPojo error=new CustomExceptionPojo();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Custom Exception handler method for INTERNAL_SERVER_ERROR
     * @param exc
     * @return Error in JSON format
     */
    @ExceptionHandler
    public ResponseEntity<CustomExceptionPojo> handleException(CustomSaveException exc){
        CustomExceptionPojo error=new CustomExceptionPojo();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Default exception handler for generic exception handling
     * @param exc
     * @return Error in JSON format
     */
    @ExceptionHandler
    public ResponseEntity<CustomExceptionPojo> handleException(Exception exc){
        CustomExceptionPojo error=new CustomExceptionPojo();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
