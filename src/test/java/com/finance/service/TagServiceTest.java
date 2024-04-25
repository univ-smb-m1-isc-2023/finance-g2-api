package com.finance.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.finance.model.Account;
import com.finance.model.Tag;
import com.finance.dtos.TagCreateDto;
import com.finance.repository.AccountRepository;
import com.finance.repository.TagRepository;

public class TagServiceTest {

    @Mock
    private TagRepository tagRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TagService tagService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllTags() {
        List<Tag> expectedTags = new ArrayList<>();
        when(tagRepository.findAll()).thenReturn(expectedTags);

        List<Tag> actualTags = tagService.allTags();

        assertNotNull(actualTags);
        assertEquals(expectedTags, actualTags);
    }

    @Test
    void testGetTags() {
        Integer accountId = 1;
        Account account = new Account();
        List<Tag> expectedTags = new ArrayList<>();
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(tagRepository.findByAccount(account)).thenReturn(expectedTags);

        List<Tag> actualTags = tagService.getTags(accountId);

        assertEquals(expectedTags, actualTags);
    }

    @Test
    void testCreateTag() {
        TagCreateDto dto = new TagCreateDto();
        dto.setAccount(1);
        dto.setName("Expense");
        dto.setDescription("Monthly expenses");

        Account account = new Account();
        Tag expectedTag = new Tag();
        expectedTag.setAccount(account);
        expectedTag.setName(dto.getName());
        expectedTag.setDescription(dto.getDescription());

        when(accountRepository.findById(dto.getAccount())).thenReturn(Optional.of(account));
        when(tagRepository.save(any(Tag.class))).thenReturn(expectedTag);

        Tag actualTag = tagService.createTag(dto);

        assertNotNull(actualTag);
        assertEquals(expectedTag.getName(), actualTag.getName());
        assertEquals(expectedTag.getDescription(), actualTag.getDescription());
    }



}
