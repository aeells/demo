package com.aeells;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.AlphaVantageException;
import com.crazzyghost.alphavantage.Config;

public abstract class AlphaVantageScheduler
{
    private static final int TIME_OUT_SECONDS = 10;

    public AlphaVantageScheduler(final AlphaVantageSecret alphaVantageSecret)
    {
        AlphaVantage.api().init(Config
            .builder()
            .key(alphaVantageSecret.getApiKey())
            .timeOut(TIME_OUT_SECONDS)
            .build());
    }

    public void handleFailure(final AlphaVantageException error)
    {
        /* uh-oh! */
        System.out.println("error: " + error.getMessage());
    }
}
