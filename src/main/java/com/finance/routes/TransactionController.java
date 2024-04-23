package com.finance.routes;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finance.dtos.TransactionCreateDto;
import com.finance.dtos.setTagDto;
import com.finance.model.Transaction;
import com.finance.service.TransactionService;

@RequestMapping("/transaction")
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/account")
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam("account") Integer accountId){
        // get from query the account id


        List<Transaction> tags = transactionService.getTransactions(accountId);

        return ResponseEntity.ok(tags);

    }

    @PostMapping("/create")
    public ResponseEntity<Transaction> createAccount(@RequestBody TransactionCreateDto tag) {
        Transaction createdTransaction = transactionService.createTransaction(tag);

        return ResponseEntity.ok(createdTransaction);
    }

    @PostMapping("/tag")
    public ResponseEntity<Transaction> tagTransaction(@RequestBody setTagDto object) {
        Transaction taggedTransaction = transactionService.setTag(object.getTransactionId(), object.getTagId());

        return ResponseEntity.ok(taggedTransaction);
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("accountId") Integer accountId) {
        try {
            System.out.println("MARCHEEE");
            // Assuming transactionService is correctly autowired and available
            transactionService.importTransactionsFromFile(file, accountId);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (Exception e) {
            // Log error details here to understand what went wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }

    
}
