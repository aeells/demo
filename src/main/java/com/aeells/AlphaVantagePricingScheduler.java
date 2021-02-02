package com.aeells;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.AlphaVantageException;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Singleton;

@Singleton
public final class AlphaVantagePricingScheduler
{
    public AlphaVantagePricingScheduler(final AlphaVantageSecret alphaVantageSecret)
    {
        AlphaVantage.api().init(Config
            .builder()
            .key(alphaVantageSecret.getApiKey())
            .timeOut(10)
            .build());
    }

    @Scheduled(cron = "0 * * * * MON-FRI")
    void everyWeekdayHourly()
    {
        AlphaVantage.api()
            .timeSeries()
            .intraday()
            .forSymbol("IBM")
            .interval(Interval.FIVE_MIN)
            .outputSize(OutputSize.FULL)
            .onSuccess(response -> handleSuccess((TimeSeriesResponse) response))
            .onFailure(this::handleFailure)
            .fetch();
    }

    public void handleSuccess(final TimeSeriesResponse response)
    {
        System.out.println("returned IBM stock units: " + response.getStockUnits().size());
    }

    public void handleFailure(final AlphaVantageException error)
    {
        /* uh-oh! */
        System.out.println("error: " + error.getMessage());
    }
}
