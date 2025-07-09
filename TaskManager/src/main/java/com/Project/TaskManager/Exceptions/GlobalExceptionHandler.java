package com.Project.TaskManager.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourcenotfound(ResourceNotFoundException ex)
    {
        Map<String,Object> body=new HashMap<>();
        body.put("timestamp:",LocalDateTime.now());
        body.put("message:",ex.getMessage());
        body.put("status:",HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badrequestfound(BadRequestException ex)
    {
        Map<String,Object> body=new HashMap<>();
        body.put("timestamp:",LocalDateTime.now());
        body.put("message:",ex.getMessage());
        body.put("status:",HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Unexpected error occurred");
        body.put("details", ex.getMessage());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
