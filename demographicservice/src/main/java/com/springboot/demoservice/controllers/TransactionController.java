package com.springboot.demoservice.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
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
public class TransactionController {

    @RequestMapping(path = "",method = RequestMethod.GET)
    public void transferBalance(HttpServletRequest request) throws IOException {
        ObjectMapper objectMapper =new ObjectMapper();

        BufferedReader reader= request.getReader();

        reader.



    }


}
