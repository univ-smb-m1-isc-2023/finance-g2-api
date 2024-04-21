package com.finance.dtos;

import java.math.BigDecimal;

public class TransactionCreateDto {

    private Integer account;

    private BigDecimal amount;

    private String date;

    private Integer tag;

    public Integer getAccount() {
        return account;
    }

    public Integer getTag() {
        return tag;
    }

    public TransactionCreateDto setTag(Integer tag) {
        this.tag = tag;
        return this;
    }

    public String getDate() {
        return date;
    }

    public TransactionCreateDto setDate(String date) {
        this.date = date;
        return this;
    }

    public TransactionCreateDto setAccount(Integer account) {
        this.account = account;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionCreateDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
    
}
