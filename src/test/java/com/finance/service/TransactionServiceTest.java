package com.finance.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.finance.dtos.TransactionCreateDto;
import com.finance.model.Account;
import com.finance.model.Tag;
import com.finance.model.Transaction;
import com.finance.repository.AccountRepository;
import com.finance.repository.TagRepository;
import com.finance.repository.TransactionRepository;

public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllTransactions() {
        List<Transaction> expectedTransactions = new ArrayList<>();
        when(transactionRepository.findAll()).thenReturn(expectedTransactions);
        assertEquals(expectedTransactions, transactionService.allTransactions());
    }

    @Test
    void testGetTransactions() {
        Integer accountId = 1;
        Account account = new Account();
        List<Transaction> expectedTransactions = new ArrayList<>();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(transactionRepository.findByAccount(account)).thenReturn(expectedTransactions);
        assertEquals(expectedTransactions, transactionService.getTransactions(accountId));
    }

    @Test
    void testCreateTransaction() {
        TransactionCreateDto dto = new TransactionCreateDto("test",1, new BigDecimal("100.00") , "2022-01-01", 1,"DEPOSIT");
        Account account = new Account();
        Tag tag = new Tag();
        Transaction expectedTransaction = new Transaction("test",account, new BigDecimal("100.00") , LocalDate.parse("2022-01-01"), tag,"DEPOSIT");
        when(accountRepository.findById(dto.getAccount())).thenReturn(Optional.of(new Account()));
        when(tagRepository.findById(dto.getTag())).thenReturn(Optional.of(new Tag()));

        transactionService.createTransaction(dto);

        verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    void testDeleteTransaction() {
        Integer transactionId = 1;
        transactionService.deleteTransaction(transactionId);
        verify(transactionRepository).deleteById(transactionId);
    }

    /*@Test
    void testImportTransactionsFromFile() throws IOException {
        String content = "Name,2023-01-01,100,DEPOSIT";
        MultipartFile file = new MockMultipartFile("file", "transactions.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", content.getBytes());
        transactionService.importTransactionsFromFile(file, 1);
        verify(transactionRepository, atLeastOnce()).saveAll(anyList());
    }*/

}
