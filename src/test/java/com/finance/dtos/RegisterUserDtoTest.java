package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterUserDtoTest {

    private RegisterUserDto registerUserDto;

    @BeforeEach
    void setUp() {
        registerUserDto = new RegisterUserDto();
        registerUserDto.setEmail("user@example.com");
        registerUserDto.setPassword("securePassword123");
        registerUserDto.setFullName("John Doe");
    }

    @Test
    void testGetEmail() {
        assertEquals("user@example.com", registerUserDto.getEmail());
    }

    @Test
    void testSetEmail() {
        registerUserDto.setEmail("newuser@example.com");
        assertEquals("newuser@example.com", registerUserDto.getEmail());
    }

    @Test
    void testGetPassword() {
        assertEquals("securePassword123", registerUserDto.getPassword());
    }

    @Test
    void testSetPassword() {
        registerUserDto.setPassword("newPassword");
        assertEquals("newPassword", registerUserDto.getPassword());
    }

    @Test
    void testGetFullName() {
        assertEquals("John Doe", registerUserDto.getFullName());
    }

    @Test
    void testSetFullName() {
        registerUserDto.setFullName("Jane Doe");
        assertEquals("Jane Doe", registerUserDto.getFullName());
    }
}
