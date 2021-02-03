package com.aeells.scheduler;

import com.aeells.config.AlphaVantageApiConfig;
import com.aeells.stock.StockMapper;
import com.aeells.stock.Ticker;
import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import com.google.gson.GsonBuilder;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Singleton;

import static java.util.Arrays.stream;

@Singleton
public final class AlphaVantagePricingScheduler extends AlphaVantageFailureHandler
{
    private final AlphaVantage alphaVantageApi;

    private final StockMapper stockMapper;

    public AlphaVantagePricingScheduler(final AlphaVantageApiConfig alphaVantageApiConfig, final StockMapper stockMapper)
    {
        this.alphaVantageApi = alphaVantageApiConfig.getAlphaVantageApi();
        this.stockMapper = stockMapper;
    }

    @Scheduled(cron = "* * * * 1-5")
    void everyWeekdayHourly()
    {
        stream(Ticker.values()).forEach(ticker ->
            this.alphaVantageApi
                .timeSeries()
                .daily() // intraday is by minute date=2021-02-01 19:59:00 | daily is presumably at close date=2021-02-02
                .forSymbol(ticker.getSymbol())
//                .intraday()
//                .forSymbol("IBM")
//                .interval(Interval.SIXTY_MIN)
                .outputSize(OutputSize.COMPACT) // FULL is historical | COMPACT is 100 rows; data is the same
                .onSuccess(response -> handleSuccess((TimeSeriesResponse) response))
                .onFailure(this::handleFailure)
                .fetch()
        );
    }

    public void handleSuccess(final TimeSeriesResponse response)
    {
        response.getStockUnits().stream().map(unit ->
            new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(stockMapper.map(unit))
        ).forEach(System.out::println);
    }
}
