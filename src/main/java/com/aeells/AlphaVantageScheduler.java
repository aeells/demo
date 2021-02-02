package com.aeells;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.AlphaVantageException;
import com.crazzyghost.alphavantage.Config;

public abstract class AlphaVantageScheduler
{
    public AlphaVantageScheduler(final AlphaVantageSecret alphaVantageSecret)
    {
        AlphaVantage.api().init(Config
            .builder()
            .key(alphaVantageSecret.getApiKey())
            .timeOut(10)
            .build());
    }

    public void handleFailure(final AlphaVantageException error)
    {
        /* uh-oh! */
        System.out.println("error: " + error.getMessage());
    }
}
