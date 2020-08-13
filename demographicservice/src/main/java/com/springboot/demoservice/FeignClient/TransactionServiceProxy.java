package com.springboot.demoservice.FeignClient;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="food-card-service")
@RibbonClient(name ="food-card-service")
public interface TransactionServiceProxy {

    @RequestMapping(method = RequestMethod.POST,path="food-service/transfer")
    public void getTransactionDetails(@RequestBody String accountDetails);


}
