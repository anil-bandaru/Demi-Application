 

package com.example.demo.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.AppErrorResponse;


@RestControllerAdvice
public class AppExceptionHandler {

   
    @ExceptionHandler(value = { Throwable.class })
    public ResponseEntity<AppErrorResponse> exceptionHandler(Exception e) {

        AppErrorResponse errRes = new AppErrorResponse("500", e.getMessage());
        return new ResponseEntity<>(errRes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
