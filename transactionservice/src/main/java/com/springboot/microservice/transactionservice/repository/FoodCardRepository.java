package com.springboot.microservice.transactionservice.repository;

import com.springboot.microservice.transactionservice.model.FoodCardAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCardRepository extends CrudRepository<FoodCardAccount,Long> {


    public FoodCardAccount findByAccountNumber(Long accountNumber);


}
