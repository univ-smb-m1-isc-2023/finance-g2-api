package com.finance.dtos;

import java.math.BigDecimal;

public class ForecastCreateDto {

    private Integer account;

    private BigDecimal amount;

    private Integer year;

    private Integer month;

    private Integer tag;

    private String type;

    public Integer getAccount() {
        return account;
    }

    public Integer getTag() {
        return tag;
    }

    public Integer getYear() {
        return year;
    }

    public ForecastCreateDto setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public ForecastCreateDto setMonth(Integer month) {
        this.month = month;
        return this;
    }


    public String getType() {
        return type;
    }

    public ForecastCreateDto setType(String type) {
        this.type = type;
        return this;
    }

    public ForecastCreateDto setTag(Integer tag) {
        this.tag = tag;
        return this;
    }

    public ForecastCreateDto setAccount(Integer account) {
        this.account = account;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ForecastCreateDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
    
}

