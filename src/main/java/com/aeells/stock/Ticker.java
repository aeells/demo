package com.aeells.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

// todo maybe move this to a database or another service at some point
// todo also needs to be batched as AlphaVantage API will barf at > 5 requests/minute

@AllArgsConstructor
public enum Ticker
{
//    IBM("IBM"),

    APPLE("AAPL");

    @Getter
    private String symbol;
}
