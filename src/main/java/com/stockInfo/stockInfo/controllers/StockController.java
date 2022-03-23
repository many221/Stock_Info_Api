package com.stockInfo.stockInfo.controllers;

import com.stockInfo.stockInfo.models.StockModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/stocks")
public class StockController  {


    private final String API_KEY = "ISDWAAVY3QPBNUN2";

    @GetMapping("/overview")
    public @ResponseBody
    StockModel getStock(@RequestParam String symbol, RestTemplate restTemplate){
       String URL = "https://www.alphavantage.co/query?function=OVERVIEW&symbol="+ symbol + "&apikey=" + API_KEY;
       StockModel response = restTemplate.getForObject ( URL,StockModel.class);

       return response;
    }

}
