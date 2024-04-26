package com.finance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finance.model.Account;
import com.finance.model.Forecast;
import com.finance.model.Tag;

@Repository
public interface ForecastRepository extends CrudRepository<Forecast, Integer> {
    Optional<Forecast> findById(Integer id);
    List<Forecast> findByAccount(Account account);
    List<Forecast> findByAccountId(Long accountId);
    List<Forecast> findByTag(Tag tag);
}

