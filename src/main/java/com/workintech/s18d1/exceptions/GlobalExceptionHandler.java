package com.workintech.s18d1.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BurgerException.class)
    public ResponseEntity<BurgerErrorResponse> handleBurgerError(BurgerException burgerErrorException){
        BurgerErrorResponse errorResponse=
                new BurgerErrorResponse(
                        burgerErrorException.getMessage());
        return new ResponseEntity<>(errorResponse,burgerErrorException.getHttpStatus());
    }

}
