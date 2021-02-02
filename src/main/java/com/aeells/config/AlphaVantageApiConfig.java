package com.aeells.config;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.AlphaVantageException;
import com.crazzyghost.alphavantage.Config;
import lombok.Getter;

import javax.inject.Singleton;

@Singleton
public final class AlphaVantageApiConfig
{
    private static final int TIME_OUT_SECONDS = 10;

    @Getter
    private final AlphaVantage alphaVantageApi;

    // singleton should ensure this is only generated the once
    public AlphaVantageApiConfig(final AlphaVantageSecret alphaVantageSecret)
    {
        this.alphaVantageApi = AlphaVantage.api();
        this.alphaVantageApi.init(Config
            .builder()
            .key(alphaVantageSecret.getApiKey())
            .timeOut(TIME_OUT_SECONDS)
            .build());
    }
}
