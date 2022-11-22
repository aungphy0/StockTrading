package com.springwebflux5.stocktrade.service;

import com.springwebflux5.stocktrade.dto.StockRequest;
import com.springwebflux5.stocktrade.dto.StockResponse;
import com.springwebflux5.stocktrade.model.Stock;
import com.springwebflux5.stocktrade.repository.StocksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StockService {

    private StocksRepository stockRepo;

    public Mono<StockResponse> getOneStock(String id){
        return stockRepo.findById(id)
                .map(StockResponse::fromModel);
    }

    public Flux<StockResponse> getAllStocks(){
        return stockRepo.findAll()
                .map(StockResponse::fromModel);
    }

    public Mono<StockResponse> createStock(StockRequest stockRequest){
        return stockRepo.save(stockRequest.toModle())
                .map(StockResponse::fromModel);
    }

}
