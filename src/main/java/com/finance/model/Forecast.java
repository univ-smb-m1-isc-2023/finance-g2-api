package com.finance.model;

import javax.persistence.*;

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

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "forecast_provision", nullable = false, scale = 2)
    private double forecastProvision;

    @Column(name = "forecast_spending", nullable = false, scale = 2)
    private double forecastSpending;

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

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getForecastProvision() {
        return forecastProvision;
    }

    public void setForecastProvision(double forecastProvision) {
        this.forecastProvision = forecastProvision;
    }

    public double getForecastSpending() {
        return forecastSpending;
    }

    public void setForecastSpending(double forecastSpending) {
        this.forecastSpending = forecastSpending;
    }
}

