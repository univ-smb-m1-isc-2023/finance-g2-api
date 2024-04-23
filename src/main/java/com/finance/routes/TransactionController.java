package com.finance.routes;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finance.dtos.TransactionCreateDto;
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
    public ResponseEntity<Transaction> tagTransaction(@RequestBody Integer transactionId, @RequestBody Integer tagId) {
        Transaction taggedTransaction = transactionService.setTag(transactionId, tagId);

        return ResponseEntity.ok(taggedTransaction);
    }



    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("accountId") Integer accountId) {
        try {
            transactionService.importTransactionsFromFile(file, accountId);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
        }
    }

    
}
