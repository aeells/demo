package com.aeells;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloWorldClientSpec
{
    @Inject
    HelloWorldClient client;

    @Test
    public void testHelloWorldResponse()
    {
        assertEquals("Hello Andrew!", client.hello().blockingGet());
    }
}
