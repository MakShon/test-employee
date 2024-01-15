package com.example.test.exeption;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity<String> handleValidationException(ValidationException e) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
//    }
}


