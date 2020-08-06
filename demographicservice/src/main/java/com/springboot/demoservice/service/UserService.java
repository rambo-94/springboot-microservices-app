package com.springboot.demoservice.service;

import com.springboot.demoservice.model.User;
import com.springboot.demoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){

        User user = userRepository.findByUsername(username);

        return user;
    }

     public User save(User user){

         return userRepository.save(user);
     }

}
