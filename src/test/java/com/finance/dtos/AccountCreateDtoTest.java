package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AccountCreateDtoTest {

    private AccountCreateDto accountCreateDto;

    @BeforeEach
    void setUp() {
        accountCreateDto = new AccountCreateDto();
        accountCreateDto.setUser(1); // Assuming the user ID is an integer
        accountCreateDto.setAccountName("Savings Account");
        accountCreateDto.setBalance(new BigDecimal("1000.00"));
    }

    @Test
    void testGetUser() {
        assertEquals(Integer.valueOf(1), accountCreateDto.getUser());
    }

    @Test
    void testSetUser() {
        accountCreateDto.setUser(2);
        assertEquals(Integer.valueOf(2), accountCreateDto.getUser());
    }

    @Test
    void testGetAccountName() {
        assertEquals("Savings Account", accountCreateDto.getAccountName());
    }

    @Test
    void testSetAccountName() {
        accountCreateDto.setAccountName("Emergency Fund");
        assertEquals("Emergency Fund", accountCreateDto.getAccountName());
    }

    @Test
    void testGetBalance() {
        assertEquals(0, new BigDecimal("1000.00").compareTo(accountCreateDto.getBalance()));
    }

    @Test
    void testSetBalance() {
        accountCreateDto.setBalance(new BigDecimal("2000.00"));
        assertEquals(0, new BigDecimal("2000.00").compareTo(accountCreateDto.getBalance()));
    }
}
