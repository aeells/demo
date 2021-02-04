package com.aeells.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter @AllArgsConstructor
public final class Stock
{
    private final String symbol;

    private final double open;

    private final double high;

    private final double low;

    private final double close;

    private final double adjustedClose;

    private final long volume;

    private final double dividendAmount;

    private final double splitCoefficient;

    // primarily this is the important bit
    private final Instant date;
}
