package com.springwebflux5.stocktrade.controller;

import com.springwebflux5.stocktrade.dto.StockRequest;
import com.springwebflux5.stocktrade.dto.StockResponse;
import com.springwebflux5.stocktrade.model.Stock;
import com.springwebflux5.stocktrade.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/stocks")
public class StocksController {

    private StockService stockService;

    @GetMapping("/{id}")
    public Mono<StockResponse> getOneStock(@PathVariable String id){
        return stockService.getOneStock(id);
    }

    @GetMapping
    public Flux<StockResponse> getAllStocks(){
        return stockService.getAllStocks();
    }

    @PostMapping
    public Mono<StockResponse> createStock(@RequestBody StockRequest stock){
        return stockService.createStock(stock);
    }

}
