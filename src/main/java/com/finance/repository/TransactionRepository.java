package com.finance.repository;

import com.finance.model.Account;
import com.finance.model.Tag;
import com.finance.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByAccount(Account account);
    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByTag(Tag tag);
}
