package com.springboot.demographicservice.service;

import com.springboot.demographicservice.model.Demographics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface LoginService extends CrudRepository<Demographics,Long> {

   public Demographics findByUsername(String Username);


}
