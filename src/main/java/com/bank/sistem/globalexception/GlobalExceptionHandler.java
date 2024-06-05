package com.bank.sistem.globalexception;

import com.bank.sistem.exceptions.AccountNotFoundException;
import com.bank.sistem.exceptions.InsufficientFundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//This is class for handing custom exceptions or exceptions,
//It is marked with controller advice so the spring can recognise it and search trought whole programs for errors
//When the custom exception is thrown it gets the status and searches first here if there is any definiton
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class) // Here we implement on what class we want to use
    public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException ae){
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        body.put("message", ae.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        // And here we specify on which status should it display this , not_found , created and etc.
    }

    //We can use WebRequest object in parameters for additional informations

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<Object> handleInsufficientFundsException(InsufficientFundsException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND); // da se dzirne koj https  status kje bide ako akaunt nema paricki, nigga broke
    }
}
