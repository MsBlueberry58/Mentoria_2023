package com.bruna.guedes.fleet_control.api.routes

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/external/routes")
class RouteController {

    @GetMapping
    fun availableRoutes(): ResponseEntity<RouteListResponse> {
        if(failure)
            return ResponseEntity.internalServerError().build()
        return ResponseEntity.ok().body(RouteListResponse(listOf(
            RouteResponse(UUID.randomUUID(), "São Paulo", "Santo André")
        )))
    }

    @PostMapping
    fun toggleFailure(): ResponseEntity<Any> {
        failure = !failure
        return ResponseEntity.noContent().build()
    }

    companion object {
        private var failure: Boolean = false
    }
}

data class RouteListResponse (
    val routes: List<RouteResponse>
)

data class RouteResponse (
    val id: UUID,
    val origin: String,
    val destination: String
)