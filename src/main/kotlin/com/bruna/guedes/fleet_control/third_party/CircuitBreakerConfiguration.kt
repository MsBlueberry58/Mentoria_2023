package com.bruna.guedes.fleet_control.third_party

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.github.resilience4j.micrometer.tagged.TaggedCircuitBreakerMetrics
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration


@Configuration
class CircuitBreakerConfiguration {

    @Bean
    fun genericCircuitBreakerRegistry(meterRegistry: MeterRegistry): CircuitBreakerRegistry {
        val ofDefaults = CircuitBreakerRegistry.ofDefaults()
        TaggedCircuitBreakerMetrics
            .ofCircuitBreakerRegistry(ofDefaults)
            .bindTo(meterRegistry)
        return ofDefaults
    }

    @Bean
    fun routeCircuitBreakerConfig() =
        CircuitBreakerConfig.custom()
            .failureRateThreshold(50F)
            .waitDurationInOpenState(Duration.ofSeconds(10))
            .permittedNumberOfCallsInHalfOpenState(2)
            .slidingWindowSize(6)
            .build()

    @Bean
    fun routeCircuitBreaker(genericCircuitBreakerRegistry: CircuitBreakerRegistry) =
        genericCircuitBreakerRegistry.circuitBreaker("routeCircuitBreaker", routeCircuitBreakerConfig())
}