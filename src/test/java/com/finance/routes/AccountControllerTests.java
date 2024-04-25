/*package com.finance.routes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.finance.service.AccountService;
import com.finance.service.JwtService;
import com.finance.model.Account;
import com.finance.model.User;
import com.finance.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finance.config.ApplicationConfiguration;
import com.finance.dtos.AccountCreateDto;
import com.finance.service.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTests {

    private MockMvc mockMvc;
    
    @MockBean
    private AccountService accountService;

    @MockBean
    private Authentication authentication;

    @MockBean
    private SecurityContext securityContext;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private UserDetailsService userDetailsService;
    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        AccountService mockAccountService = mock(AccountService.class);
        AccountController controller = new AccountController(mockAccountService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    void savedUser() {
      User user = new User("zaphod", "zaphod@mail.com");
      User savedUser = userRepository.save(user);
        assertThat(savedUser.getUsername()).isNotNull();
    }


    /*@BeforeEach
    void setUp() {
        when(jwtService.extractUsername(anyString())).thenReturn("user@example.com");
        when(jwtService.isTokenValid(anyString(), any())).thenReturn(true);

        UserDetails userDetails = new User("user@example.com", "password");
        when(userDetailsService.loadUserByUsername(anyString())).thenReturn(userDetails);
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
        // Create a new AccountCreateDto object and set its properties
        AccountCreateDto newAccount = new AccountCreateDto()
                .setUser(1) // Assuming a user ID for testing
                .setAccountName("Savings Account")
                .setBalance(new BigDecimal("1000.00"));

        // Create the Account object that would be returned by the service
        Account savedAccount = new Account();
        savedAccount.setId(1L);
        savedAccount.setBalance(new BigDecimal("1000.00"));
        savedAccount.setAccountName("Savings Account");
        // Assuming Account class has setter methods similar to AccountCreateDto

        // Mock the service call to return the created account
        when(accountService.createAccount(any(AccountCreateDto.class))).thenReturn(savedAccount);

        // Convert the AccountCreateDto to JSON string for the request payload
        ObjectMapper objectMapper = new ObjectMapper();
        String newAccountJson = objectMapper.writeValueAsString(newAccount);

        // Perform the POST request, passing the JSON payload
        mockMvc.perform(post("/account/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newAccountJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.balance").value(1000.00))
                .andExpect(jsonPath("$.accountName").value("Savings Account"));
    } 


}*/
