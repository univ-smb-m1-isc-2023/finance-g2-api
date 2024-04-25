package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagCreateDtoTest {

    private TagCreateDto tagCreateDto;

    @BeforeEach
    void setUp() {
        tagCreateDto = new TagCreateDto();
        tagCreateDto.setName("Budget");
        tagCreateDto.setDescription("Monthly budget for expenses");
        tagCreateDto.setAccount(1); // Assuming the account is identified by an integer ID
    }

    @Test
    void testGetName() {
        assertEquals("Budget", tagCreateDto.getName());
    }

    @Test
    void testSetName() {
        tagCreateDto.setName("Savings");
        assertEquals("Savings", tagCreateDto.getName());
    }

    @Test
    void testGetDescription() {
        assertEquals("Monthly budget for expenses", tagCreateDto.getDescription());
    }

    @Test
    void testSetDescription() {
        tagCreateDto.setDescription("Annual budget for expenses");
        assertEquals("Annual budget for expenses", tagCreateDto.getDescription());
    }

    @Test
    void testGetAccount() {
        assertEquals(Integer.valueOf(1), tagCreateDto.getAccount());
    }

    @Test
    void testSetAccount() {
        tagCreateDto.setAccount(2);
        assertEquals(Integer.valueOf(2), tagCreateDto.getAccount());
    }
}
