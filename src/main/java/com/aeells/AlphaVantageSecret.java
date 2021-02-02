package com.aeells;

import io.micronaut.context.annotation.Value;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Singleton;

@Singleton
@Getter
public final class AlphaVantageSecret
{
    @Value("${alphavantage.api_key}")
    private String apiKey;
}
