package com.finance.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dtos.AccountCreateDto;
import com.finance.model.Account;
import com.finance.model.User;
import com.finance.service.AccountService;

import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/me")
    public ResponseEntity<List<Account>> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        List<Account> accounts = accountService.getAccounts(currentUser);

        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/")
    public ResponseEntity<List<Account>> allAccounts() {
        List <Account> accounts = accountService.allAccounts();

        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountCreateDto account) {
        Account createdAccount = accountService.createAccount(account);

        return ResponseEntity.ok(createdAccount);
    }
}
