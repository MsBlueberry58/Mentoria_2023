package com.bruna.guedes.fleet_control.third_party

import feign.Feign
import feign.jackson.JacksonDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {

    @Bean
    fun routeClient(): RouteApiClient {
        return Feign.builder()
            .decoder(JacksonDecoder())
            .target(RouteApiClient::class.java, "http://localhost:8080")
    }
}