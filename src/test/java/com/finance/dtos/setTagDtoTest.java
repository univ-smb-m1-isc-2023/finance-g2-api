package com.finance.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTagDtoTest {

    private setTagDto setTagDto;

    @BeforeEach
    void setUp() {
        setTagDto = new setTagDto();
        setTagDto.setTransactionId(100);
        setTagDto.setTagId(200);
    }

    @Test
    void testGetTransactionId() {
        assertEquals(Integer.valueOf(100), setTagDto.getTransactionId());
    }

    @Test
    void testSetTransactionId() {
        setTagDto.setTransactionId(101);
        assertEquals(Integer.valueOf(101), setTagDto.getTransactionId());
    }

    @Test
    void testGetTagId() {
        assertEquals(Integer.valueOf(200), setTagDto.getTagId());
    }

    @Test
    void testSetTagId() {
        setTagDto.setTagId(201);
        assertEquals(Integer.valueOf(201), setTagDto.getTagId());
    }
}
