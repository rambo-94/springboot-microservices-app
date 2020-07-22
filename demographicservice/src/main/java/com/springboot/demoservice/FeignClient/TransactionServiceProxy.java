package com.springboot.demoservice.FeignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="transaction-service",url="localhost:8002")

public interface TransactionServiceProxy {

    @RequestMapping(method = RequestMethod.GET,path="transaction-service/transfer")
    public void getTransactionDetails(@RequestBody String accountDetails);


}
