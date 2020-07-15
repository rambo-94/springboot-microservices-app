package com.springboot.demographicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemographicsService  {

    @Autowired
    private final DemographicsService demographicsService;

    public DemographicsService(DemographicsService demographicsService) {
        this.demographicsService = demographicsService;
    }
}
