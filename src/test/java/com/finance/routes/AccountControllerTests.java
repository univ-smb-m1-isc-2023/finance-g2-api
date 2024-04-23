/*package com.finance.routes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.finance.service.AccountService;
import com.finance.model.Account;
import com.finance.model.User;
import com.finance.dtos.AccountCreateDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private Authentication authentication;

    @MockBean
    private SecurityContext securityContext;

    @BeforeEach
    void setUp() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    @WithMockUser
    void authenticatedUserAccounts() throws Exception {
        Account account = new Account();
        account.setId(1L);
        account.setBalance(new BigDecimal((1000.00)));

        List<Account> accounts = Arrays.asList(account);
        when(authentication.getPrincipal()).thenReturn(new User()); // Assuming User class has a no-arg constructor
        when(accountService.getAccounts(any(User.class))).thenReturn(accounts);

        mockMvc.perform(get("/account/me")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].balance").value(1000.00));
    }

    @Test
    @WithMockUser
    void allAccounts() throws Exception {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setBalance(new BigDecimal((1000.00)));
        Account account2 = new Account();
        account2.setId(2L);
        account2.setBalance(new BigDecimal((2000.00)));

        List<Account> accounts = Arrays.asList(account1, account2);
        when(accountService.allAccounts()).thenReturn(accounts);

        mockMvc.perform(get("/account/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].balance").value(1000.00))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].balance").value(2000.00));
    }

    @Test
    @WithMockUser
    void createAccount() throws Exception {
        AccountCreateDto newAccount = new AccountCreateDto(); // Set properties as necessary
        Account savedAccount = new Account();
        savedAccount.setId(1L);
        savedAccount.setBalance(new BigDecimal((1000.00)));

        when(accountService.createAccount(any(AccountCreateDto.class))).thenReturn(savedAccount);

        mockMvc.perform(post("/account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"balance\": 1000.00}") // Adjust JSON content to match AccountCreateDto structure
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.balance").value(1000.00));
    }
}*/
