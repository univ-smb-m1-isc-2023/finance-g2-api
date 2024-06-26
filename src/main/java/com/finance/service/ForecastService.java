package com.finance.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
import com.finance.repository.TransactionRepository;

@Service
public class ForecastService {

    private final ForecastRepository forecastRepository;
    private final AccountRepository accountRepository;
    private final TagRepository tagRepository;

    public ForecastService(ForecastRepository forecastRepository, AccountRepository accountRepository, TagRepository tagRepository) {
        this.forecastRepository = forecastRepository;
        this.accountRepository = accountRepository;
        this.tagRepository = tagRepository;
    }

    public List<Forecast> allForecast() {
        List<Forecast> forecasts = new ArrayList<Forecast>();

        forecastRepository.findAll().forEach(forecasts::add);

        return forecasts;
    }

    public List<Forecast> getForecasts(Integer account) {

        Account acc = accountRepository.findById(account).orElse(null);


        List<Forecast> forecasts = forecastRepository.findByAccount(acc);

        if (forecasts == null) {
            return new ArrayList<Forecast>();
        }

        return forecasts;
    }

    public Forecast createTransaction(ForecastCreateDto forecast) {

        Forecast fore = new Forecast();

        accountRepository.findById(forecast.getAccount()).ifPresent(fore::setAccount);
        tagRepository.findById(forecast.getTag()).ifPresent(fore::setTag);
        System.out.println(forecast.getAmount());
        fore.setAmount(forecast.getAmount());
        System.out.println(forecast.getMonth());
        fore.setMonth(forecast.getMonth());
        System.out.println(forecast.getYear());
        fore.setYear(forecast.getYear());

        fore.setType(forecast.getType());

        return forecastRepository.save(fore);
    }

    public Iterable<Forecast> createForecastMultipleYear(ForecastMultipleCreateDto forecast) {

        System.out.println("forecastmultiple");
        System.out.println(forecast.getNbOfYears());

        List<Forecast> forecasts = new ArrayList<Forecast>();

        for (int i = 0; i < forecast.getNbOfYears().intValueExact(); i++) {
            Forecast fore = new Forecast();

            accountRepository.findById(forecast.getAccount()).ifPresent(fore::setAccount);
            tagRepository.findById(forecast.getTag()).ifPresent(fore::setTag);

            fore.setAmount(forecast.getAmount().divide(forecast.getNbOfYears()));
            fore.setMonth(forecast.getMonth());
            fore.setYear(forecast.getYear() + i);

            fore.setType(forecast.getType());

            forecasts.add(fore);


        }

        return forecastRepository.saveAll(forecasts);
        
    }

    public List<Forecast> getFromTags(Integer tagid) {
        Tag tag = tagRepository.findById(tagid).orElse(null);
        List<Forecast> transactions = forecastRepository.findByTag(tag);

        return transactions;

    }


    
}
