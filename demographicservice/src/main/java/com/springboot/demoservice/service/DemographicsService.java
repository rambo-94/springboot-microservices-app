package com.springboot.demoservice.service;

import com.springboot.demoservice.model.Demographics;
import com.springboot.demoservice.repository.DemographicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemographicsService  {

    @Autowired
    private final DemographicsRepository demographicsRepository;


    public DemographicsService(DemographicsRepository demographicsRepository) {
        this.demographicsRepository = demographicsRepository;

    }

    public Demographics retrieveDemog(String Username){

        return demographicsRepository.findByUsername(Username);

    }

}
