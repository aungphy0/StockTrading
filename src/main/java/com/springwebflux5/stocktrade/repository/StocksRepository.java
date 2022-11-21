package com.springwebflux5.stocktrade.repository;

import com.springwebflux5.stocktrade.model.Stock;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends ReactiveMongoRepository<Stock, String> {

}
