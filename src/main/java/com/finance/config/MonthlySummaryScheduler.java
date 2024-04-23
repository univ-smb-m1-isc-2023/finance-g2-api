package com.finance.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.finance.model.Account;
import com.finance.model.Forecast;
import com.finance.model.Transaction;
import com.finance.model.User;
import com.finance.repository.AccountRepository;
import com.finance.repository.ForecastRepository;
import com.finance.repository.TagRepository;
import com.finance.repository.TransactionRepository;
import com.finance.repository.UserRepository;
//import com.finance.service.EmailService;
import com.finance.model.Tag;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MonthlySummaryScheduler {

    private final ForecastRepository forecastRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    //private final EmailService emailService;

    public MonthlySummaryScheduler(ForecastRepository forecastRepository, /*EmailService emailService,*/
                                   UserRepository userRepository, TagRepository tagRepository,
                                   AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.forecastRepository = forecastRepository;
        //this.emailService = emailService;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Scheduled(cron = "0 0 0 L * ?") // Runs at midnight on the last day of every month
    public void sendMonthlySummary() {
        // Fetch all users
        Iterable<User> users = userRepository.findAll();

        // Process each user
        for (User user : users) {
            List<Account> accounts = accountRepository.findByUserId(user.getId());
            StringBuilder emailContent = new StringBuilder();

            // Process each account
            for (Account account : accounts) {
                List<Forecast> forecasts = forecastRepository.findByAccountId(account.getId());
                List<Transaction> transactions = transactionRepository.findByAccountId(account.getId());

                // Grouping by tag
                Map<Long, BigDecimal> totalForecastsByTag = forecasts.stream()
                    .collect(Collectors.groupingBy(
                        Forecast::getTagId,
                        Collectors.reducing(BigDecimal.ZERO, Forecast::getAmount, BigDecimal::add)));

                Map<Long, BigDecimal> totalActualsByTag = transactions.stream()
                    .collect(Collectors.groupingBy(
                        Transaction::getTagId,
                        Collectors.reducing(BigDecimal.ZERO, Transaction::getAmount, BigDecimal::add)));

                // Append results per tag to email content
                totalForecastsByTag.forEach((tagId, forecastAmount) -> {
                    BigDecimal actualAmount = totalActualsByTag.getOrDefault(tagId, BigDecimal.ZERO);
                    Tag tag = tagRepository.findById(tagId).orElse(null);
                    if (tag != null) {
                        emailContent.append(String.format("Account: %s, Tag: %s%nForecast Total: %s%nActual Total: %s%nDifference: %s%n%n",
                            account.getAccountName(),
                            tag.getName(),
                            forecastAmount.toPlainString(),
                            actualAmount.toPlainString(),
                            forecastAmount.subtract(actualAmount).toPlainString()));
                    }
                });
            }

            // Send email to user
            //emailService.sendEmail(user.getEmail(), "Monthly Financial Summary by Tags", emailContent.toString());
        }
    }
}
