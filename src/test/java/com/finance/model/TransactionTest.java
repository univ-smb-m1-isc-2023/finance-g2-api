package com.finance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

class TransactionTest {

    private Transaction transaction;
    private Account account;
    private Tag tag;

    @BeforeEach
    void setUp() {
        account = new Account();
        account.setId(1L);
        account.setAccountName("Savings Account");
        account.setBalance(new BigDecimal("1000.00"));

        tag = new Tag();
        tag.setId(1L);
        tag.setName("Groceries");

        transaction = new Transaction("Grocery Purchase", new BigDecimal("150.00"), LocalDate.of(2023, 4, 20), account, "Debit");
        transaction.setId(1L);
        transaction.setTag(tag);
    }

    @Test
    void testId() {
        assertEquals(1L, transaction.getId());
    }

    @Test
    void testName() {
        assertEquals("Grocery Purchase", transaction.getName());
        transaction.setName("New Purchase");
        assertEquals("New Purchase", transaction.getName());
    }

    @Test
    void testType() {
        assertEquals("Debit", transaction.getType());
        transaction.setType("Credit");
        assertEquals("Credit", transaction.getType());
    }

    @Test
    void testAccount() {
        assertNotNull(transaction.getAccount());
        assertEquals(1L, transaction.getAccount().getId());
    }

    @Test
    void testAmount() {
        assertEquals(0, new BigDecimal("150.00").compareTo(transaction.getAmount()));
        transaction.setAmount(new BigDecimal("200.00"));
        assertEquals(0, new BigDecimal("200.00").compareTo(transaction.getAmount()));
    }

    @Test
    void testTransactionDate() {
        assertEquals(LocalDate.of(2023, 4, 20), transaction.getTransactionDate());
        transaction.setTransactionDate(LocalDate.of(2023, 5, 21));
        assertEquals(LocalDate.of(2023, 5, 21), transaction.getTransactionDate());
    }

    @Test
    void testTag() {
        assertNotNull(transaction.getTag());
        assertEquals(1L, transaction.getTag().getId());
        transaction.setTag(null);
        assertNull(transaction.getTagId());
    }
}
