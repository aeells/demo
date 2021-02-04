package com.aeells.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

// todo maybe move this to a database or another service at some point
// todo also needs to be batched as AlphaVantage API will barf at > 5 requests/minute

@AllArgsConstructor
public enum Ticker
{
    APPLE("AAPL"),
    AMAZON("AMZN"),
    DISNEY("DIS"),
    GOOGLE("GOOG"),
    MICROSOFT("MSFT"),
    SONY("SNE"),

    // stick with tickers i'm certain of for now...
//    FTSE_100("UKX"),
//    FTSE_250("MCX"),
//    BARRICK_GOLD("ABX"),

    ;

    @Getter
    private final String symbol;
}
