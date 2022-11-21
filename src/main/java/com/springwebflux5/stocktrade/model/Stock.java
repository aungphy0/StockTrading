package com.springwebflux5.stocktrade.model;


import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    private String id;

    private String name;

    @NonNull
    private Double price;

    private String currency;


}
