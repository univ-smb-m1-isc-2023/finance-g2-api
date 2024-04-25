package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class TransactionCreateDtoTest {

    private TransactionCreateDto transactionCreateDto;

    @BeforeEach
    void setUp() {
        transactionCreateDto = new TransactionCreateDto();
        transactionCreateDto.setAccount(1);
        transactionCreateDto.setAmount(new BigDecimal("100.00"));
        transactionCreateDto.setDate("2023-10-01");
        transactionCreateDto.setTag(1);
        transactionCreateDto.setType("Expense");
    }

    @Test
    void testGetAccount() {
        assertEquals(Integer.valueOf(1), transactionCreateDto.getAccount());
    }

    @Test
    void testSetAccount() {
        transactionCreateDto.setAccount(2);
        assertEquals(Integer.valueOf(2), transactionCreateDto.getAccount());
    }

    @Test
    void testGetAmount() {
        assertEquals(0, new BigDecimal("100.00").compareTo(transactionCreateDto.getAmount()));
    }

    @Test
    void testSetAmount() {
        transactionCreateDto.setAmount(new BigDecimal("200.00"));
        assertEquals(0, new BigDecimal("200.00").compareTo(transactionCreateDto.getAmount()));
    }

    @Test
    void testGetDate() {
        assertEquals("2023-10-01", transactionCreateDto.getDate());
    }

    @Test
    void testSetDate() {
        transactionCreateDto.setDate("2023-10-02");
        assertEquals("2023-10-02", transactionCreateDto.getDate());
    }

    @Test
    void testGetTag() {
        assertEquals(Integer.valueOf(1), transactionCreateDto.getTag());
    }

    @Test
    void testSetTag() {
        transactionCreateDto.setTag(2);
        assertEquals(Integer.valueOf(2), transactionCreateDto.getTag());
    }

    @Test
    void testGetType() {
        assertEquals("Expense", transactionCreateDto.getType());
    }

    @Test
    void testSetType() {
        transactionCreateDto.setType("Income");
        assertEquals("Income", transactionCreateDto.getType());
    }
}
