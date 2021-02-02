package com.aeells.scheduler;

import com.aeells.config.AlphaVantageApiConfig;
import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.sector.response.SectorResponse;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Singleton;

@Singleton
public final class AlphaVantageSectorScheduler extends AlphaVantageFailureHandler
{
    private final AlphaVantage alphaVantageApi;

    // singleton should ensure this is only generated the once
    public AlphaVantageSectorScheduler(final AlphaVantageApiConfig alphaVantageApiConfig)
    {
        this.alphaVantageApi = alphaVantageApiConfig.getAlphaVantageApi();
    }

    @Scheduled(cron = "00 22 * * 1-5")
    void everyWeekdayDaily()
    {
        this.alphaVantageApi
            .sector()
            .onSuccess(this::handleDailySuccess)
            .onFailure(this::handleFailure)
            .fetch();
    }

    public void handleDailySuccess(final SectorResponse response)
    {
        System.out.println("returned sector responses: " + response.toString());
    }
}
