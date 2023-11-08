package com.bruna.guedes.fleet_control.external.routes


import io.micrometer.core.instrument.MeterRegistry
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

@RestController
@RequestMapping("/external/routes")
class RouteController(val meterRegistry: MeterRegistry) {

    private var toggleNumber: AtomicInteger =
        meterRegistry.gauge(METRIC_ROUTE_TOGGLE, AtomicInteger(0))!!

    @GetMapping
    fun availableRoutes(): ResponseEntity<RouteListResponse> {
        if (failure)
            return ResponseEntity.internalServerError().build()
        return ResponseEntity.ok().body(
            RouteListResponse(
                listOf(
                    RouteResponse(UUID.randomUUID(), "São Paulo", "Santo André")
                )
            )
        )
    }

    @PostMapping
    fun toggleFailure(): ResponseEntity<Any> {
        failure = !failure
        toggleNumber.set(failure.toNumber())
        return ResponseEntity.noContent().build()
    }

    companion object {
        private var failure: Boolean = false
        private const val METRIC_ROUTE_TOGGLE = "route.toggle"
    }
}

data class RouteListResponse(
    val routes: List<RouteResponse>
)

data class RouteResponse(
    val id: UUID,
    val origin: String,
    val destination: String
)

fun Boolean.toNumber() = if (this) 1 else 0