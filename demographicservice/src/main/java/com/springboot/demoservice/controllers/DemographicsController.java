package com.springboot.demoservice.controllers;

import com.springboot.demoservice.model.Demographics;
import com.springboot.demoservice.service.DemographicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/details")
@CrossOrigin(origins = "http://localhost:4200")
public class DemographicsController {


    @Autowired
    private  DemographicsService demographicsService ;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET,path = "/{username}")
     Demographics  retrieveDetails(@PathVariable("username") String username){

        return demographicsService.retrieveDemog(username);

    }
}
