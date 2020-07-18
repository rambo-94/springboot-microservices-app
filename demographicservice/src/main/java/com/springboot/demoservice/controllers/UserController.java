package com.springboot.demoservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demoservice.model.User;
import com.springboot.demoservice.service.UserService;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;
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
    Object checkLoginCredentials(@PathVariable("username") String username) throws JSONException {



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

        objectMapper.createObjectNode().put("message","Saved Successful");


        return new ResponseEntity(objectMapper, HttpStatus.OK);


    }




}
