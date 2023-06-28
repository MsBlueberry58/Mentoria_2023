package com.bruna.guedes.fleet_control.third_party

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.IOException
import java.time.Duration
import java.util.concurrent.TimeoutException


@Configuration
class CircuitBreakerConfiguration {

    @Bean
    fun genericCircuitBreakerRegistry() =
        CircuitBreakerRegistry.ofDefaults()

    @Bean
    fun routeCircuitBreakerConfig() =
        CircuitBreakerConfig.custom()
            .failureRateThreshold(50F)
            .waitDurationInOpenState(Duration.ofSeconds(10))
            .permittedNumberOfCallsInHalfOpenState(2)
            .slidingWindowSize(6)
            .build()

    @Bean
    fun routeCircuitBreaker() =
        genericCircuitBreakerRegistry().circuitBreaker("routeCircuitBreaker", routeCircuitBreakerConfig())
}