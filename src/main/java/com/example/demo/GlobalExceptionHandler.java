package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> handleMyException(MyException myException) {
        return ResponseEntity.internalServerError().body(myException.getMessage());
    }

    @ExceptionHandler(ETLException.class)
    public ResponseEntity<String> handleETLException(ETLException etlException) {
        return ResponseEntity.internalServerError().body(etlException.getMessage());
    }
}
