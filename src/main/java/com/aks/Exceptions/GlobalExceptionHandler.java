package com.aks.Exceptions;

import com.aks.Exceptions.BadRequestException;
import com.aks.Exceptions.CustomNotFoundException;
import com.aks.Exceptions.CustomGenericException;
import com.aks.Exceptions.DatabaseDownException;
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
    public ResponseEntity<CustomExceptionPojo> handleException(CustomNotFoundException exc){
        CustomExceptionPojo error=new CustomExceptionPojo();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Custom Exception handler method for INTERNAL_SERVER_ERROR and all other generic exceptions
     * @param exc
     * @return Error in JSON format
     */
    @ExceptionHandler({CustomGenericException.class, Exception.class})
    public ResponseEntity<CustomExceptionPojo> handleException(CustomGenericException exc){
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
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<CustomExceptionPojo> handleException(BadRequestException exc){
        CustomExceptionPojo error=new CustomExceptionPojo();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    /**
     * Custom Exception handler method for SERVICE_UNAVAILABLE
     * @param exc
     * @return Error in JSON format
     */
    @ExceptionHandler
    public ResponseEntity<CustomExceptionPojo> handleException(DatabaseDownException exc){
        CustomExceptionPojo error=new CustomExceptionPojo();
        error.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        error.setMessage(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
