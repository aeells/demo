package com.aeells.stock;

import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import io.micronaut.context.annotation.Prototype;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Prototype
public final class StockMapper
{
    public Stock map(final StockUnit unit)
    {
        final Instant instant = LocalDate.parse(unit.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.of("America/Los_Angeles")).toInstant();

        return new Stock(unit.getOpen(), unit.getHigh(), unit.getLow(), unit.getClose(), unit.getAdjustedClose(), unit.getVolume(), unit.getDividendAmount(), unit.getSplitCoefficient(), instant);
    }
}
