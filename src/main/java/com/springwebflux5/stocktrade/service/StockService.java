package com.springwebflux5.stocktrade.service;

import com.springwebflux5.stocktrade.dto.StockRequest;
import com.springwebflux5.stocktrade.dto.StockResponse;
import com.springwebflux5.stocktrade.exception.StockCreationException;
import com.springwebflux5.stocktrade.exception.StockNotFoundException;
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
                .map(StockResponse::fromModel)
                .switchIfEmpty(Mono.error(
                        new StockNotFoundException(
                                "Stock not found with id: " + id )));
    }

    public Flux<StockResponse> getAllStocks(Double priceGreaterThan){
        return stockRepo.findAll()
                .filter(stock -> stock.getPrice().compareTo(priceGreaterThan) > 0)
                .map(StockResponse::fromModel);
    }

    public Mono<StockResponse> createStock(StockRequest stockRequest){
        return Mono.just(stockRequest)
                .map(StockRequest::toModle)
                .flatMap(stock -> stockRepo.save(stock))
                .map(StockResponse::fromModel)
                .onErrorMap(ex -> new StockCreationException(ex.getMessage()));
    }

}
