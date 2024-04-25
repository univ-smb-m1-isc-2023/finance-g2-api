package com.finance.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.finance.model.Account;
import com.finance.model.User;
import com.finance.dtos.AccountCreateDto;
import com.finance.repository.AccountRepository;
import com.finance.repository.UserRepository;

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllAccounts() {
        List<Account> expectedAccounts = new ArrayList<>();
        when(accountRepository.findAll()).thenReturn(expectedAccounts);

        List<Account> actualAccounts = accountService.allAccounts();
        
        assertNotNull(actualAccounts);
        assertEquals(expectedAccounts, actualAccounts);
    }

    @Test
    void testGetAccounts() {
        User user = new User();
        List<Account> expectedAccounts = new ArrayList<>();
        
        when(accountRepository.findByUser(user)).thenReturn(expectedAccounts);

        List<Account> actualAccounts = accountService.getAccounts(user);

        assertEquals(expectedAccounts, actualAccounts);
    }
    @Test
    void testCreateAccount() {
        AccountCreateDto dto = new AccountCreateDto();
        dto.setUser(1);  // Assuming User ID is Long
        dto.setAccountName("Savings");
        dto.setBalance(new BigDecimal("1000.00"));

        Account expectedAccount = new Account();
        expectedAccount.setUser(new User()); // Assuming User constructor sets an empty user
        expectedAccount.setAccountName(dto.getAccountName());
        expectedAccount.setBalance(dto.getBalance());

        when(userRepository.findById(dto.getUser())).thenReturn(Optional.of(new User()));
        when(accountRepository.save(any(Account.class))).thenReturn(expectedAccount);

        Account actualAccount = accountService.createAccount(dto);

        assertNotNull(actualAccount);
        assertEquals(expectedAccount.getAccountName(), actualAccount.getAccountName());
        assertEquals(expectedAccount.getBalance(), actualAccount.getBalance());
    }

    


}

