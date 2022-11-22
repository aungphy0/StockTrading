package com.springwebflux5.stocktrade.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.springwebflux5.stocktrade.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {

    @JsonProperty("stockName")
    private String name;

    private Double price;

    private String currency;

    public Stock toModle(){
        return Stock.builder()
                .name(this.name)
                .price(this.price)
                .currency(this.currency)
                .build();
    }

}
