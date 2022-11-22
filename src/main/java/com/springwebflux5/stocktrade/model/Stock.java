package com.springwebflux5.stocktrade.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Stock {

    @Id
    private String id;

    private String name;

    @NonNull
    private Double price;

    private String currency;


}
