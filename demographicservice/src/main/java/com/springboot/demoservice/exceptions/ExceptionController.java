package com.springboot.demoservice.exceptions;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionController {

    public ResponseEntity transactionFailed(){

        ObjectMapper objectMapper =new ObjectMapper();

        objectMapper.createObjectNode().put("message","insufficient balance to withdraw");

        return new ResponseEntity(objectMapper, HttpStatus.EXPECTATION_FAILED);
    }


}
