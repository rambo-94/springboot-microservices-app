package com.springboot.demoservice.repository;


import com.springboot.demoservice.model.User;
import org.springframework.data.repository.CrudRepository;
import sun.security.mscapi.CPublicKey;

public interface UserRepository extends CrudRepository<User,Long> {


    public User findByUsername(String username);


}
