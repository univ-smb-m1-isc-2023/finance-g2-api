package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginUserDtoTest {

    private LoginUserDto loginUserDto;

    @BeforeEach
    void setUp() {
        loginUserDto = new LoginUserDto();
        loginUserDto.setEmail("test@example.com");
        loginUserDto.setPassword("password123");
    }

    @Test
    void testGetEmail() {
        assertEquals("test@example.com", loginUserDto.getEmail());
    }

    @Test
    void testSetEmail() {
        loginUserDto.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", loginUserDto.getEmail());
    }

    @Test
    void testGetPassword() {
        assertEquals("password123", loginUserDto.getPassword());
    }

    @Test
    void testSetPassword() {
        loginUserDto.setPassword("newPassword");
        assertEquals("newPassword", loginUserDto.getPassword());
    }
    
}
