package com.finance.dtos;

public class TagCreateDto {

    private String name;
    private String description;
    private Integer account;

    public String getName() {
        return name;
    }

    public TagCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TagCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getAccount() {
        return account;
    }

    public TagCreateDto setAccount(Integer account) {
        this.account = account;
        return this;
    }
    

}
