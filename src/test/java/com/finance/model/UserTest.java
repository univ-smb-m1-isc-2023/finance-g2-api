package com.finance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("user@example.com", "password123");
        user.setFullName("John Doe");
    }

    @Test
    void testUserProperties() {
        assertEquals("user@example.com", user.getUsername());
        assertEquals("user@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("John Doe", user.getFullName());
    }

    @Test
    void testUserEmail() {
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail());
    }

    @Test
    void testUserPassword() {
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }

    @Test
    void testUserFullName() {
        user.setFullName("Jane Doe");
        assertEquals("Jane Doe", user.getFullName());
    }

    @Test
    void testUserAuthorities() {
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        assertTrue(authorities.isEmpty()); // Check that by default no authorities are granted
    }

    @Test
    void testUserAccountStatus() {
        assertTrue(user.isAccountNonExpired());
        assertTrue(user.isAccountNonLocked());
        assertTrue(user.isCredentialsNonExpired());
        assertTrue(user.isEnabled());
    }
}
