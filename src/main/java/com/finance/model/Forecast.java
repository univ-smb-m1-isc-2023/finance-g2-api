package com.finance.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "forecasts")
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forecast_seq_generator")
    @SequenceGenerator(name = "forecast_seq_generator", sequenceName = "forecast_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "months", nullable = false)
    private int months;

    @Column(name = "years", nullable = false)
    private int years;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "type", nullable = false)
    private String type;

    public Forecast() {}

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tag getTag() {
        return tag;
    }

    public Long getTagId() {
        return tag.getId();
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int getMonth() {
        return months;
    }

    public void setMonth(int months) {
        this.months = months;
    }

    public int getYear() {
        return years;
    }

    public void setYear(int years) {
        this.years = years;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

