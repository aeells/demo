package com.aeells.stock;

import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import io.micronaut.context.annotation.Prototype;
import lombok.SneakyThrows;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Prototype
public final class StockMapper
{
    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    public Stock map(final StockUnit unit)
    {
        mapperFactory.classMap(StockUnit.class, Stock.class).customize(new CustomMapper<>()
        {
            @SneakyThrows
            @Override
            public void mapAtoB(final StockUnit src, final Stock dest, final MappingContext context)
            {
                dest.setDate(LocalDate.parse(src.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    .atStartOfDay(ZoneId.of("America/Los_Angeles"))
                    .toInstant());
            }
        }).register();

        return mapperFactory.getMapperFacade().map(unit, Stock.class);
    }
}
