package com.springwebflux5.stocktrade.service;

import com.springwebflux5.stocktrade.repository.StocksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockService {

    private StocksRepository stockRepo;


}
