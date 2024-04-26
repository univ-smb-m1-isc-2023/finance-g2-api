package com.finance.routes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dtos.ForecastCreateDto;
import com.finance.dtos.ForecastMultipleCreateDto;
import com.finance.model.Forecast;
import com.finance.service.ForecastService;

@RequestMapping("/forecast")
@RestController
public class ForecastController {

    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/account")
    public ResponseEntity<List<Forecast>> getTransactions(@RequestParam("account") Integer accountId){
        // get from query the account id


        List<Forecast> tags = forecastService.getForecasts(accountId);

        return ResponseEntity.ok(tags);

    }

    @PostMapping("/create")
    public ResponseEntity<Forecast> createAccount(@RequestBody ForecastCreateDto tag) {
        Forecast createdTransaction = forecastService.createTransaction(tag);

        return ResponseEntity.ok(createdTransaction);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<Forecast>> createMultiple(@RequestBody ForecastMultipleCreateDto forecast) {
        Iterable<Forecast> createdTransactions = forecastService.createForecastMultipleYear(forecast);

            List<Forecast> result = new ArrayList<Forecast>();
            createdTransactions.forEach(result::add);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getfromtags")
    public ResponseEntity<List<Forecast>> getFromTags(@RequestParam("tag") Integer tags){
        List<Forecast> forecasts = forecastService.getFromTags(tags);

        return ResponseEntity.ok(forecasts);
    }
    
}
