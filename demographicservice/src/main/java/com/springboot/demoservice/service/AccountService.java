package com.springboot.demoservice.service;

import com.springboot.demoservice.exceptions.NotEnoughBalanceException;
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


        List<Accounts> accounts=accountRepository.findAllByUser(user.getId());

        accounts.forEach((acc) ->{

            if(acc.getAccountType()== accountType)
            acc.setBalance(amount + acc.getBalance());
            accountRepository.save(acc);

        });



    }

    public void withdrawFunds(String username,Long amount,String accountType) throws NotEnoughBalanceException {



        User user = userRepository.findByUsername(username);
        List<Accounts> accounts=accountRepository.findAllByUser(user.getId());


        accounts.forEach((acc) ->{

            if(acc.getAccountType() == accountType){
               if(acc.getBalance()< amount) {
                   throw new NotEnoughBalanceException("not enogh balance");
               }

                acc.setBalance(amount + acc.getBalance());
            }


            accountRepository.save(acc);

        });
    }
}
