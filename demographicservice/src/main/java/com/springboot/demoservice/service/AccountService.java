package com.springboot.demoservice.service;

import com.springboot.demoservice.model.Accounts;
import com.springboot.demoservice.model.User;
import com.springboot.demoservice.repository.AccountRepository;
import com.springboot.demoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;


@Service
public class AccountService {

    @Autowired
    public final AccountRepository accountRepository;

    @Autowired
    public final UserRepository userRepository;


    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }


    public void  addFunds(String username,double amount,String accountType){

        User user = userRepository.findByUsername(username);
        final double[] balance = new double[1];

        List<Accounts> accounts=accountRepository.findAllByUser(user.getId());

        accounts.forEach((acc) ->{

            if(acc.getAccountType()== accountType)
                balance[0] = amount + acc.getBalance();
            acc.setBalance(balance[0]);
            accountRepository.save(acc);

        });


          
    }

    public void withdrawFunds(String Username,Long amount) {




    }
}
