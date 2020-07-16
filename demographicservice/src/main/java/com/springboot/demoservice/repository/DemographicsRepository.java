package com.springboot.demoservice.repository;

import com.springboot.demoservice.model.Demographics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemographicsRepository extends CrudRepository<Demographics,Long> {

    public Demographics findByUsername(String Username);


}
