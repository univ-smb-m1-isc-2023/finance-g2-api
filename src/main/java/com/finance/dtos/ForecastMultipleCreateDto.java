package com.finance.dtos;

import java.math.BigDecimal;

public class ForecastMultipleCreateDto extends ForecastCreateDto{

   private BigDecimal nbOfYears;

    public BigDecimal getNbOfYears() {
         return nbOfYears;
    }

    public ForecastMultipleCreateDto setNbOfYears(BigDecimal nbOfYears) {
        this.nbOfYears = nbOfYears;
        return this;
    }

    
}


