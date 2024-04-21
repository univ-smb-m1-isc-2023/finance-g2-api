package com.finance.dtos;

import java.math.BigDecimal;

import com.finance.model.User;

public class AccountCreateDto {

    private Integer user;

    private String accountName;

    private BigDecimal balance;

    public Integer getUser() {
        return user;
    }

    public AccountCreateDto setUser(Integer user) {
        this.user = user;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public AccountCreateDto setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountCreateDto setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }
    
}
