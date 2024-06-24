package com.example.rest_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.channels.ClosedByInterruptException;

@ControllerAdvice
public class CloudVendorExceptionController {

    @ExceptionHandler(value={ClosedByInterruptException.class})
    public ResponseEntity<Object> handleCloudVendorNotFound
            (CloudVendorNotFoundException cloudVendorNotFoundException){
        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}
