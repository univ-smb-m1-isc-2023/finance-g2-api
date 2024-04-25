package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ForecastMultipleCreateDtoTest {

    private ForecastMultipleCreateDto forecastMultipleCreateDto;

    @BeforeEach
    void setUp() {
        forecastMultipleCreateDto = new ForecastMultipleCreateDto();
        forecastMultipleCreateDto.setAccount(1);
        forecastMultipleCreateDto.setTag(1);
        forecastMultipleCreateDto.setYear(2023);
        forecastMultipleCreateDto.setMonth(12);
        forecastMultipleCreateDto.setType("Expense");
        forecastMultipleCreateDto.setAmount(new BigDecimal("500.00"));
        forecastMultipleCreateDto.setNbOfYears(new BigDecimal("5"));
    }

    @Test
    void testInheritedProperties() {
        // Testing properties inherited from ForecastCreateDto
        assertEquals(Integer.valueOf(1), forecastMultipleCreateDto.getAccount());
        assertEquals(Integer.valueOf(1), forecastMultipleCreateDto.getTag());
        assertEquals(Integer.valueOf(2023), forecastMultipleCreateDto.getYear());
        assertEquals(Integer.valueOf(12), forecastMultipleCreateDto.getMonth());
        assertEquals("Expense", forecastMultipleCreateDto.getType());
        assertEquals(0, new BigDecimal("500.00").compareTo(forecastMultipleCreateDto.getAmount()));
    }

    @Test
    void testNbOfYears() {
        // Testing the property specific to ForecastMultipleCreateDto
        assertEquals(0, new BigDecimal("5").compareTo(forecastMultipleCreateDto.getNbOfYears()));
        forecastMultipleCreateDto.setNbOfYears(new BigDecimal("10"));
        assertEquals(0, new BigDecimal("10").compareTo(forecastMultipleCreateDto.getNbOfYears()));
    }
}
