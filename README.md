## Micronaut 2.3.0 Documentation

- [User Guide](https://docs.micronaut.io/2.3.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.3.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.3.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Incredibly fast startup 

[How I Achieved Incredibly fast Java Micronaut Service Startup Times with GraalVM](https://www.poornerd.com/2020/05/20/incredibly-fast-java-service-startup-speed-graalvm.html)

```
> sdk default java 21.0.0.r11-grl
> gu install native-image
> ./mvnw package -Dpackaging=native-image
> ./target/micronaut-demo
```

## Run with external configuration

```
> ./mvnw mn:run -Dmicronaut.config.files=/Users/aeells/.micronaut/credentials.yml
```
