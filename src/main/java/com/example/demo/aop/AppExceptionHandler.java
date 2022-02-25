/*  
*  
* Copyright (c) 2020 OLAM Limited  
*  
* All information contained herein is, and remains the property of OLAM  
* Limited. The intellectual and technical concepts contained herein are  
* proprietary to OLAM and are protected by trade secret or copyright law.  
* Dissemination of this information or reproduction of this material is  
* strictly forbidden unless prior written permission is obtained from OLAM  
* Limited  
*  
*/  

package com.example.demo.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.AppErrorResponse;


/**
 * Class for Handling all the AppException
 * @version 1.0
 */
@RestControllerAdvice
public class AppExceptionHandler {

   
    @ExceptionHandler(value = { Throwable.class })
    public ResponseEntity<AppErrorResponse> exceptionHandler(Exception e) {

        AppErrorResponse errRes = new AppErrorResponse("500", e.getMessage());
        return new ResponseEntity<>(errRes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
