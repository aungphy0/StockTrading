package com.springwebflux5.stocktrade.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StockNotFoundException extends Throwable{

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
