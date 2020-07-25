package com.springboot.demoservice.service;

import com.springboot.demoservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    public final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void  addFunds(String Username,Long amount){



    }

    public void withdrawFunds(String Username,Long amount) {




    }
}
