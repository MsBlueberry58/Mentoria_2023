package com.bruna.guedes.fleet_control.infrastructure.http

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import feign.jackson.JacksonDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {

    @Bean
    fun routeClient(mapper: ObjectMapper): RouteApiClient {
        return Feign.builder()
            .decoder(JacksonDecoder(mapper))
            .target(RouteApiClient::class.java, "http://localhost:8083")
    }
}