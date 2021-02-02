package com.aeells;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;
import lombok.Setter;

@Introspected
@Getter
@Setter
public final class AlphaVantagePrice
{
    private String name;

    private boolean linked;
}
