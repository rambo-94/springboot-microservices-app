package com.springboot.microservice.transactionservice.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.microservice.transactionservice.model.FoodCardAccount;
import com.springboot.microservice.transactionservice.service.FoodCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.function.Function;

@Controller
@RequestMapping(path = "/food-card")
public class FoodCardController {


    @Autowired
    public final FoodCardService foodCardService;


    public FoodCardController(FoodCardService foodCardService) {
        this.foodCardService = foodCardService;
    }

    @RequestMapping(method = RequestMethod.POST,path = "/topup")
    public void AddFundsToCard(String json) throws JsonProcessingException {
        ObjectMapper objectMapper =new ObjectMapper();
        JsonNode jsonNode=objectMapper.readTree(json);
        Long accountNumber = jsonNode.get("accoutNumber").asLong();
        Long deposit = jsonNode.get("deposit").asLong();

        foodCardService.addFunds(accountNumber,deposit);



    }
    @RequestMapping(method = RequestMethod.GET,path = "/getDetails")

    public ResponseEntity getFoodCardDetails(Long accountNumber){

        return new ResponseEntity<>( foodCardService.getDetails(accountNumber),HttpStatus.ACCEPTED);

    }

    @RequestMapping(method = RequestMethod.POST,path = "/create")
    public ResponseEntity createAccountForFoodCard(Long accountNumber){

        ObjectMapper objectMapper =new ObjectMapper();

        Function<String,String> cardNumber= (account) ->{

            for(int i=0;i<3;i++) {
                account = account + Math.floor(Math.random() * 10);
            }

            return account;
        };


        FoodCardAccount savingAcc = new FoodCardAccount(accountNumber,Long.parseLong(cardNumber.apply("124")),0);
        foodCardService.createAccountForFoodCard(savingAcc);
        objectMapper.createObjectNode().put("message","Account created Successfully");
        return new ResponseEntity(objectMapper, HttpStatus.OK);


    }
}
