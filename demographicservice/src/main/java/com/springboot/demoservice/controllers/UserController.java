package com.springboot.demoservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demoservice.model.Accounts;

import com.springboot.demoservice.model.User;
import com.springboot.demoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;


@RestController
@RequestMapping("/owners")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET,path = "/login/{username}")
    Object checkLoginCredentials(@PathVariable("username") String username) {



        Optional<User> user= Optional.ofNullable(this.userService.findByUsername(username));

        Predicate<Optional> predicate=(x) -> x.isPresent();
        if(predicate.test(user)) {

            return ResponseEntity.ok().body(String.format("{ \"username\" : %s , \"password\" : %s }", user.get().getUsername(), user.get().getPassword()));

        }
        return "{\"message\":\"No username found\"}";

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT,path = "/register}")
    ResponseEntity saveRegistrationDetails(@RequestBody HashMap<String,Object> json){

        ObjectMapper objectMapper =new ObjectMapper();

        User user= (User) json.get("User");

        Function<String,String> accountNumber= (account) ->{

            for(int i=0;i<3;i++) {
                account = account + Math.floor(Math.random() * 10);
            }

            return account;
        };
        
        Accounts savingAcc = new Accounts(Long.parseLong( accountNumber.apply("124")),"Savings",0);
        Accounts checkingAcc = new Accounts(Long.parseLong(accountNumber.apply("987")),"Checking",0);
        List<Accounts> accounts =new ArrayList<>();
        accounts.add(savingAcc);
        accounts.add(checkingAcc);
        user.setAccounts(accounts);
        userService.save(user);
        objectMapper.createObjectNode().put("message","Saved Successful");


        return new ResponseEntity(objectMapper, HttpStatus.OK);


    }




}
