package com.aeells;

import io.micronaut.context.annotation.Value;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Singleton;

@Singleton
public final class AlphaVantagePricingClient
{
    @Value("${alphavantage.api_key}")
    public String accessKeyId;

    @Scheduled(cron = "0 * * * * MON-FRI")
    void everyWeekdayHourly()
    {
        System.out.println("accessKey = " + accessKeyId);
    }
}
