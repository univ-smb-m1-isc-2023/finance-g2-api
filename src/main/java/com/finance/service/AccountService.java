package com.finance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.finance.dtos.AccountCreateDto;
import com.finance.model.Account;
import com.finance.model.User;
import com.finance.repository.AccountRepository;
import com.finance.repository.UserRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public List<Account> allAccounts() {
        List<Account> accounts = new ArrayList<>();

        accountRepository.findAll().forEach(accounts::add);

        return accounts;
    }

    public List<Account> getAccounts(User user) {
        List<Account> accounts = new ArrayList<>();

        accountRepository.findByUser(user).ifPresent(accounts::add);

        return accounts;
    }

    public Account createAccount(AccountCreateDto account) {

        Account acc = new Account();

        userRepository.findById(account.getUser()).ifPresent(acc::setUser);

        acc.setBalance(account.getBalance());
        acc.setAccountName(account.getAccountName());

        return accountRepository.save(acc);
    }
}
