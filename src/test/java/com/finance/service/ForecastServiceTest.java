package com.finance.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.finance.dtos.ForecastCreateDto;
import com.finance.dtos.ForecastMultipleCreateDto;
import com.finance.dtos.TransactionCreateDto;
import com.finance.model.Account;
import com.finance.model.Forecast;
import com.finance.model.Tag;
import com.finance.model.Transaction;
import com.finance.repository.AccountRepository;
import com.finance.repository.ForecastRepository;
import com.finance.repository.TagRepository;

public class ForecastServiceTest {

    @Mock
    private ForecastRepository forecastRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private ForecastService forecastService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

      @Test
    void testAllForecasts() {
        List<Forecast> expectedForecasts = new ArrayList<>();
        when(forecastRepository.findAll()).thenReturn(expectedForecasts);
        assertEquals(expectedForecasts, forecastService.allForecast());
    }

    @Test
    void testGetForecast() {
        Integer accountId = 1;
        Account account = new Account();
        List<Forecast> expectedForecasts = new ArrayList<>();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(forecastRepository.findByAccount(account)).thenReturn(expectedForecasts);
        assertEquals(expectedForecasts, forecastService.getForecasts(accountId));
    }

    /*@Test
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
    void testDeleteForecast() {
        Integer transactionId = 1;
        forecastService.delete(transactionId);
        verify(transactionRepository).deleteById(transactionId);
    }*/
}

