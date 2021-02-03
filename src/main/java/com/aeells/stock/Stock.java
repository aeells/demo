package com.aeells.stock;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
@NoArgsConstructor
public final class Stock
{
    private double open;

    private double high;

    private double low;

    private double close;

    private double adjustedClose;

    private int volume;

    private double dividendAmount;

    private double splitCoefficient;

    // primarily this is the important bit
    private Instant date;
}
