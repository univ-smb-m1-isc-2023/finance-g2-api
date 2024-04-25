package com.finance.dtos;

public class setTagDto {
    
    private Integer transactionId;
    private Integer tagId;

    public Integer getTransactionId() {
        return transactionId;
    }

    public setTagDto setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public Integer getTagId() {
        return tagId;
    }

    public setTagDto setTagId(Integer tagId) {
        this.tagId = tagId;
        return this;
    }

}
