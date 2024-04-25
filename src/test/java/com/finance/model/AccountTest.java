package com.finance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class AccountTest {

    private Account account;
    private User user;

    @BeforeEach
    void setUp() {
        account = new Account();
        user = new User("user@example.com", "password123");  // Assuming User has these constructor parameters
        user.setId(1);

        account.setId(1L);
        account.setUser(user);
        account.setBalance(new BigDecimal("1000.00"));
        account.setAccountName("Checking Account");
    }

    @Test
    void testAccountProperties() {
        assertEquals(1L, account.getId());
        assertSame(user, account.getUser());  // Using assertSame to ensure it references the same object
        assertEquals(new BigDecimal("1000.00"), account.getBalance());
        assertEquals("Checking Account", account.getAccountName());
    }

    @Test
    void testAccountUser() {
        User newUser = new User("newuser@example.com", "newpassword");
        newUser.setId(2);
        account.setUser(newUser);
        assertEquals(2, account.getUser().getId());
        assertEquals("newuser@example.com", account.getUser().getEmail());
    }

    @Test
    void testAccountBalance() {
        account.setBalance(new BigDecimal("500.00"));
        assertEquals(0, new BigDecimal("500.00").compareTo(account.getBalance()));
    }

    @Test
    void testAccountName() {
        account.setAccountName("Savings Account");
        assertEquals("Savings Account", account.getAccountName());
    }
}

