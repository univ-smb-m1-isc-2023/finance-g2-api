package com.finance.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq_generator")
    @SequenceGenerator(name = "transaction_seq_generator", sequenceName = "transaction_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Column(name = "name")
    private String name;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    @Nullable
    private Tag tag;

    @Column(name = "type")
    private String type;
    

    public Transaction() {}

    public Transaction(String name,Account account, BigDecimal amount, LocalDate date, Tag tag, String type) {
        this.name = name;
        this.account = account;
        this.amount = amount;
        this.transactionDate = date;
        this.tag = tag;
        this.type = type;
    }

    public Transaction(String name, BigDecimal amount, LocalDate transactionDate, Account account, String type) {
        this.name = name;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;
        this.type = type;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Tag getTag() {
        return tag == null ? new Tag() : tag;
    }

    public Long getTagId() {
        return tag != null ? tag.getId() : null;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

