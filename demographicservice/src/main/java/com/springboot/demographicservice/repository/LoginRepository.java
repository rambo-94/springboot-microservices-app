package com.springboot.demographicservice.repository;

import com.springboot.demographicservice.model.Demographics;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Demographics,Long> {


}
