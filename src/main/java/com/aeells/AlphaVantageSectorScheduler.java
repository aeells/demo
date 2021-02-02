package com.aeells;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.sector.response.SectorResponse;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Singleton;

@Singleton
public final class AlphaVantageSectorScheduler extends AlphaVantageScheduler
{
    public AlphaVantageSectorScheduler(final AlphaVantageSecret alphaVantageSecret)
    {
        super(alphaVantageSecret);
    }

    @Scheduled(cron = "00 22 * * 1-5")
    void everyWeekdayDaily()
    {
        AlphaVantage.api()
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
