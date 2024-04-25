package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ForecastCreateDtoTest {

    private ForecastCreateDto forecastCreateDto;

    @BeforeEach
    void setUp() {
        forecastCreateDto = new ForecastCreateDto();
        forecastCreateDto.setAccount(1);
        forecastCreateDto.setTag(1);
        forecastCreateDto.setYear(2023);
        forecastCreateDto.setMonth(12);
        forecastCreateDto.setType("Expense");
        forecastCreateDto.setAmount(new BigDecimal("500.00"));
    }

    @Test
    void testGetAccount() {
        assertEquals(Integer.valueOf(1), forecastCreateDto.getAccount());
    }

    @Test
    void testSetAccount() {
        forecastCreateDto.setAccount(2);
        assertEquals(Integer.valueOf(2), forecastCreateDto.getAccount());
    }

    @Test
    void testGetTag() {
        assertEquals(Integer.valueOf(1), forecastCreateDto.getTag());
    }

    @Test
    void testSetTag() {
        forecastCreateDto.setTag(2);
        assertEquals(Integer.valueOf(2), forecastCreateDto.getTag());
    }

    @Test
    void testGetYear() {
        assertEquals(Integer.valueOf(2023), forecastCreateDto.getYear());
    }

    @Test
    void testSetYear() {
        forecastCreateDto.setYear(2024);
        assertEquals(Integer.valueOf(2024), forecastCreateDto.getYear());
    }

    @Test
    void testGetMonth() {
        assertEquals(Integer.valueOf(12), forecastCreateDto.getMonth());
    }

    @Test
    void testSetMonth() {
        forecastCreateDto.setMonth(11);
        assertEquals(Integer.valueOf(11), forecastCreateDto.getMonth());
    }

    @Test
    void testGetType() {
        assertEquals("Expense", forecastCreateDto.getType());
    }

    @Test
    void testSetType() {
        forecastCreateDto.setType("Income");
        assertEquals("Income", forecastCreateDto.getType());
    }

    @Test
    void testGetAmount() {
        assertEquals(0, new BigDecimal("500.00").compareTo(forecastCreateDto.getAmount()));
    }

    @Test
    void testSetAmount() {
        forecastCreateDto.setAmount(new BigDecimal("1000.00"));
        assertEquals(0, new BigDecimal("1000.00").compareTo(forecastCreateDto.getAmount()));
    }
}
