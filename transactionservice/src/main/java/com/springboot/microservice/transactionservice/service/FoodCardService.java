package com.springboot.microservice.transactionservice.service;


import com.springboot.microservice.transactionservice.model.FoodCardAccount;
import com.springboot.microservice.transactionservice.repository.FoodCardRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodCardService {


    private final FoodCardRepository foodCardRepository;
    public FoodCardService(FoodCardRepository foodCardRepository) {
        this.foodCardRepository = foodCardRepository;
    }


    public void addFunds(Long accountNumber,Long balance){

        FoodCardAccount foodCardAccount =getDetails(accountNumber);
        foodCardAccount.setBalance(foodCardAccount.getBalance() + balance);

        foodCardRepository.save(foodCardAccount);


    }

    public void createAccountForFoodCard(FoodCardAccount account){


        foodCardRepository.save(account);


    }

    public FoodCardAccount getDetails(Long accountNumber) {

        return foodCardRepository.findByAccountNumber(accountNumber);
    }
}
