package com.bruna.guedes.fleet_control.infrastructure.http

import com.bruna.guedes.fleet_control.external.routes.RouteListResponse
import feign.RequestLine
import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.vavr.control.Try
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component


fun interface RouteApiClient {

    @RequestLine("GET /external/routes")
    fun routes(): RouteListResponse
}

@Component
class DecoratedRouteApiClient(
    private val routeApiClient: RouteApiClient,
    @Qualifier("routeCircuitBreaker") private val circuitBreaker: CircuitBreaker
) {

    fun routes(): RouteListResponse {

        val supplier =
            circuitBreaker.decorateSupplier {
                routeApiClient.routes()
            }
        return Try.ofSupplier(supplier)
            .recover { RouteListResponse(listOf()) }
            .get()
    }

}