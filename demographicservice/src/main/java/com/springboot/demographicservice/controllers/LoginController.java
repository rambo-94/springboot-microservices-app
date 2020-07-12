package com.springboot.demographicservice.controllers;

import com.springboot.demographicservice.model.Demographics;
import com.springboot.demographicservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/owners")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController  {

    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET,path = "/login/{username}")
    void checkLoginCredentials(@PathVariable("username") String username){

     this.loginService.findByUsername(username);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT,path = "/register}")
    void saveRegistrationDetails(@RequestBody Demographics username){

        this.loginService.save(username);


    }

    @RequestMapping(method = RequestMethod.GET,path = "/details/{username}")
    void retrieveDetails(@PathVariable("username") String username){

        this.loginService.findByUsername(username);

    }


}
