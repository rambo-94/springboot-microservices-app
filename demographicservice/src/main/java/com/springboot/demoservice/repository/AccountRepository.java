package com.springboot.demoservice.repository;

import com.springboot.demoservice.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Long> {

    List<Accounts> findAllByUser(Long userId);

}
