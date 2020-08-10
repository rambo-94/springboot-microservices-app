package com.springboot.microservice.transactionservice.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.microservice.transactionservice.model.FoodCardAccount;
import com.springboot.microservice.transactionservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Function;

@Controller
@RequestMapping(path = "/food-card")
public class TopUpController {


    @Autowired
    public final CardService cardService;

    public TopUpController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping(method = RequestMethod.POST,path = "/topup")
    public void AddFundsToCard(){


        cardService.addFunds();



    }

    @RequestMapping(method = RequestMethod.POST,path = "/create")
    public ResponseEntity createAccountForFoodCard(Long accountNumber ){

        ObjectMapper objectMapper =new ObjectMapper();

        Function<String,String> cardNumber= (account) ->{

            for(int i=0;i<3;i++) {
                account = account + Math.floor(Math.random() * 10);
            }

            return account;
        };


        FoodCardAccount savingAcc = new FoodCardAccount(accountNumber,Long.parseLong(cardNumber.apply("124")),0);

        objectMapper.createObjectNode().put("message","Account created Successfully");

        return new ResponseEntity(objectMapper, HttpStatus.OK);


    }
}
