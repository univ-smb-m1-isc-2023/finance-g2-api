package com.finance.repository;

import com.finance.model.Account;
import com.finance.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    Optional<Tag> findById(Integer id);
    Optional<Tag> findByAccount(Account account);
}
