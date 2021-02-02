package com.aeells.scheduler;

import com.aeells.config.AlphaVantageApiConfig;
import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Singleton;

@Singleton
public final class AlphaVantagePricingScheduler extends AlphaVantageFailureHandler
{
    private final AlphaVantage alphaVantageApi;

    public AlphaVantagePricingScheduler(final AlphaVantageApiConfig alphaVantageApiConfig)
    {
        this.alphaVantageApi = alphaVantageApiConfig.getAlphaVantageApi();
    }

    @Scheduled(cron = "* * * * 1-5")
    void everyWeekdayHourly()
    {
        this.alphaVantageApi
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
