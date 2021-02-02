package com.aeells.scheduler;

import com.crazzyghost.alphavantage.AlphaVantageException;

abstract class AlphaVantageFailureHandler
{
    public void handleFailure(final AlphaVantageException error)
    {
        /* uh-oh! */
        System.out.println("error: " + error.getMessage());
    }
}
