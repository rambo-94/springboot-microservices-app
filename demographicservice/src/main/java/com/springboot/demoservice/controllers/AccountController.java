package com.springboot.demoservice.controllers;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demoservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
@RequestMapping("/transfer")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {


    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(path = "",method = RequestMethod.GET)
    public void depositFunds(HttpServletRequest request) throws IOException {
        ObjectMapper objectMapper =new ObjectMapper();

        BufferedReader reader= request.getReader();

        //JSONObject json = new JSONObject( reader.toString());

        JsonNode jsonNode= objectMapper.readTree(reader);
        String username = jsonNode.get("username").asText();
        Long depositAmount = jsonNode.get("amount").asLong();


      accountService.addFunds(username,depositAmount);

    }


    @RequestMapping(path = "",method = RequestMethod.GET)
    public void withdrawFunds(HttpServletRequest request) throws IOException {
        ObjectMapper objectMapper =new ObjectMapper();

        BufferedReader reader= request.getReader();


        JsonNode jsonNode= objectMapper.readTree(reader);
        String username = jsonNode.get("username").asText();
        Long withdrawAmount = jsonNode.get("amount").asLong();



        accountService.withdrawFunds(username,withdrawAmount);

    }


}
