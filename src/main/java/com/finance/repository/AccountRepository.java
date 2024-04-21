package com.finance.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finance.model.Account;
import com.finance.model.User;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    Optional<Account> findById(Integer id);
    Optional<Account> findByUser(User user);
}
