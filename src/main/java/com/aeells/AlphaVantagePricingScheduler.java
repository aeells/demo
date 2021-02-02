package com.aeells;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Singleton;

@Singleton
public final class AlphaVantagePricingScheduler extends AlphaVantageScheduler
{
    public AlphaVantagePricingScheduler(final AlphaVantageSecret alphaVantageSecret)
    {
        super(alphaVantageSecret);
    }

    @Scheduled(cron = "* * * * 1-5")
    void everyWeekdayHourly()
    {
        AlphaVantage.api()
            .timeSeries()
            .intraday()
            .forSymbol("IBM")
            .interval(Interval.SIXTY_MIN)
            .outputSize(OutputSize.FULL)
            .onSuccess(response -> handleHourlySuccess((TimeSeriesResponse) response))
            .onFailure(this::handleFailure)
            .fetch();
    }

    public void handleHourlySuccess(final TimeSeriesResponse response)
    {
        System.out.println("returned IBM stock units: " + response.getStockUnits().size());
    }
}
