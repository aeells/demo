package com.aeells.config;

import io.micronaut.context.annotation.Value;
import lombok.Getter;

import javax.inject.Singleton;

@Singleton
@Getter
public final class AlphaVantageSecret
{
    @Value("${alphavantage.api_key}")
    private String apiKey;
}
