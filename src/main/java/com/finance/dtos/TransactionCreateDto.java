package com.finance.dtos;

import java.math.BigDecimal;

public class TransactionCreateDto {

    private String name;

    private Integer account;

    private BigDecimal amount;

    private String date;

    private Integer tag;

    private String type;

    public TransactionCreateDto(){}

    public TransactionCreateDto(String name,Integer account, BigDecimal amount, String date, Integer tag, String type) {
        this.name = name;
        this.account = account;
        this.amount = amount;
        this.date = date;
        this.tag = tag;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public TransactionCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAccount() {
        return account;
    }

    public Integer getTag() {
        return tag;
    }

    public String getType() {
        return type;
    }

    public TransactionCreateDto setType(String type) {
        this.type = type;
        return this;
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
