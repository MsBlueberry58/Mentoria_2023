package com.bruna.guedes.fleet_control.third_party

import com.bruna.guedes.fleet_control.api.routes.RouteListResponse
import feign.RequestLine


interface RouteApiClient {

    @RequestLine("GET /external/routes")
    fun routes(): RouteListResponse
}