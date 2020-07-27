package com.springboot.demoservice.service;

import com.springboot.demoservice.model.Accounts;
import com.springboot.demoservice.model.User;
import com.springboot.demoservice.repository.AccountRepository;
import com.springboot.demoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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


    public void  addFunds(String username,Long amount){

        User user = userRepository.findByUsername(username);

        List<Accounts> accounts=accountRepository.findAllByUser(user.getId());




    }

    public void withdrawFunds(String Username,Long amount) {




    }
}
