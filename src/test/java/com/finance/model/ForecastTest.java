package com.finance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class ForecastTest {

    private Forecast forecast;
    private Tag tag;
    private Account account;

    @BeforeEach
    void setUp() {
        forecast = new Forecast();
        tag = new Tag();
        tag.setId(1L);
        tag.setName("Utilities");

        account = new Account();
        account.setId(1L);
        account.setAccountName("Checking Account");
        account.setBalance(new BigDecimal("1000.00"));

        forecast.setId(1L);
        forecast.setTag(tag);
        forecast.setAccount(account);
        forecast.setMonth(5);
        forecast.setYear(2023);
        forecast.setAmount(new BigDecimal("200.00"));
        forecast.setType("Expense");
    }

    @Test
    void testId() {
        assertEquals(1L, forecast.getId());
    }

    @Test
    void testTag() {
        assertEquals(tag, forecast.getTag());
        assertEquals(1L, forecast.getTag().getId());
    }

    @Test
    void testAccount() {
        assertEquals(account, forecast.getAccount());
    }

    @Test
    void testMonth() {
        assertEquals(5, forecast.getMonth());
    }

    @Test
    void testYear() {
        assertEquals(2023, forecast.getYear());
    }

    @Test
    void testAmount() {
        assertEquals(0, new BigDecimal("200.00").compareTo(forecast.getAmount()));
    }

    @Test
    void testType() {
        assertEquals("Expense", forecast.getType());
    }
}
