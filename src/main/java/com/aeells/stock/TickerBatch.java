package com.aeells.stock;

import org.apache.commons.collections4.iterators.LoopingListIterator;

import javax.inject.Singleton;

import java.util.List;

import static java.util.Arrays.asList;

@Singleton // just go with 4 per batch so as not to overload alpha vantage API
public final class TickerBatch
{
    private static final LoopingListIterator<Ticker> TICKERS = new LoopingListIterator<>(asList(Ticker.values()));

    public List<Ticker> getNext()
    {
        return asList(TICKERS.next(), TICKERS.next(), TICKERS.next(), TICKERS.next());
    }
}
