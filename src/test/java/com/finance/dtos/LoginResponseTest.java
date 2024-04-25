package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginResponseTest {

    private LoginResponse loginResponse;

    @BeforeEach
    void setUp() {
        loginResponse = new LoginResponse();
        loginResponse.setToken("abcdef12345");
        loginResponse.setExpiresIn(3600);  // typical expiration time in seconds
    }

    @Test
    void testGetToken() {
        assertEquals("abcdef12345", loginResponse.getToken());
    }

    @Test
    void testSetToken() {
        loginResponse.setToken("newToken12345");
        assertEquals("newToken12345", loginResponse.getToken());
    }

    @Test
    void testGetExpiresIn() {
        assertEquals(3600, loginResponse.getExpiresIn());
    }

    @Test
    void testSetExpiresIn() {
        loginResponse.setExpiresIn(7200);
        assertEquals(7200, loginResponse.getExpiresIn());
    }
}
