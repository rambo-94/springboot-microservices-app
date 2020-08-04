package com.springboot.demoservice.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.EXPECTATION_FAILED,reason = "Not enough balance to withdraw")
public class NotEnoughBalanceException extends RuntimeException{


     public NotEnoughBalanceException(String message){
         super(message);

    }
}
