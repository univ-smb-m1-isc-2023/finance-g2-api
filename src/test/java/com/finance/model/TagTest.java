package com.finance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagTest {

    private Tag tag;
    private Account account;

    @BeforeEach
    void setUp() {
        tag = new Tag();
        account = new Account();
        account.setId(1L);
        account.setAccountName("Savings Account");
        account.setBalance(new java.math.BigDecimal("1000.00"));

        tag.setId(1L);
        tag.setName("Utilities");
        tag.setDescription("Monthly utility bills");
        tag.setAccount(account);
    }

    @Test
    void testId() {
        assertEquals(1L, tag.getId());
    }

    @Test
    void testName() {
        assertEquals("Utilities", tag.getName());
        tag.setName("Groceries");
        assertEquals("Groceries", tag.getName());
    }

    @Test
    void testDescription() {
        assertEquals("Monthly utility bills", tag.getDescription());
        tag.setDescription("Expenses for groceries");
        assertEquals("Expenses for groceries", tag.getDescription());
    }

    @Test
    void testAccount() {
        assertNotNull(tag.getAccount());
        assertEquals(1L, tag.getAccount().getId());
        assertEquals("Savings Account", tag.getAccount().getAccountName());

        // Testing setting a new account
        Account newAccount = new Account();
        newAccount.setId(2L);
        newAccount.setAccountName("Checking Account");
        tag.setAccount(newAccount);
        assertEquals(2L, tag.getAccount().getId());
        assertEquals("Checking Account", tag.getAccount().getAccountName());
    }
}
