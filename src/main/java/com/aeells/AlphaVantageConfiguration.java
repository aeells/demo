package com.aeells;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;

@ConfigurationProperties(AlphaVantageConfiguration.PREFIX)
@Requires(property = AlphaVantageConfiguration.PREFIX)
public final class AlphaVantageConfiguration
{
    public static final String PREFIX = "alphavantage";

    public static final String BINTRAY_API_URL = "https://bintray.com";

    private String apiversion;

    private String organization;

    private String repository;

    private String username;

    private String token;
}
