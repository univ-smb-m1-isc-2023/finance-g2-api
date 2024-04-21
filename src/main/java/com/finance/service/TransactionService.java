package com.finance.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finance.dtos.TagCreateDto;
import com.finance.dtos.TransactionCreateDto;
import com.finance.model.Account;
import com.finance.model.Tag;
import com.finance.model.Transaction;
import com.finance.repository.AccountRepository;
import com.finance.repository.TagRepository;
import com.finance.repository.TransactionRepository;
import org.apache.poi.ss.usermodel.*;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TagRepository tagRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, TagRepository tagRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.tagRepository = tagRepository;
    }

    public List<Transaction> allTransactions() {
        List<Transaction> transactions = new ArrayList<Transaction>();

        transactionRepository.findAll().forEach(transactions::add);

        return transactions;
    }

    public List<Transaction> getTransactions(Integer account) {

        Account acc = accountRepository.findById(account).orElse(null);


        List<Transaction> transactions = transactionRepository.findByAccount(acc);

        if (transactions == null) {
            return new ArrayList<Transaction>();
        }

        return transactions;
    }

    public Transaction createTransaction(TransactionCreateDto transaction) {

        Transaction trans = new Transaction();

        accountRepository.findById(transaction.getAccount()).ifPresent(trans::setAccount);
        tagRepository.findById(transaction.getTag()).ifPresent(trans::setTag);

        trans.setAmount(transaction.getAmount());
        // convert string to date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(transaction.getDate(), formatter);

        trans.setTransactionDate(date);        
        trans.setType(transaction.getType());

        return transactionRepository.save(trans);
    }

    public void importTransactionsFromFile(MultipartFile file, Integer accountId) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Account account = accountRepository.findById(accountId).orElse(null);
        for (Row row : sheet) {

            String name = row.getCell(0).getStringCellValue();
            LocalDate date = row.getCell(1).getLocalDateTimeCellValue().toLocalDate();
            BigDecimal amount = BigDecimal.valueOf(row.getCell(2).getNumericCellValue());
            String type = row.getCell(3).getStringCellValue();

            transactions.add(new Transaction(name ,amount, date,account, type));
        }
        transactionRepository.saveAll(transactions);
        workbook.close();
    }
}
