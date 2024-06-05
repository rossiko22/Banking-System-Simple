package com.bank.sistem.globalexception;

import com.bank.sistem.exceptions.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//This is class for handing custo exceptions or exceptions,
//It is marked with controller advice so the spring can recognise it and search trought whole programs for errors
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class) // Here we implement on what class we want to use
    public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException ae, WebRequest webRequest){
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        body.put("message", ae.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        // And here we specify on which status should it display this , not_found , created and etc.
}
