package com.springboot.demoservice.controllers;

import com.springboot.demoservice.model.Demographics;
import com.springboot.demoservice.service.DemographicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/details")
public class DemographicsController {


    @Autowired
    private  DemographicsService demographicsService ;



    @RequestMapping(method = RequestMethod.GET,path = "/{username}")
     Demographics  retrieveDetails(@PathVariable("username") String username){

        return demographicsService.retrieveDemog(username);

    }
}
