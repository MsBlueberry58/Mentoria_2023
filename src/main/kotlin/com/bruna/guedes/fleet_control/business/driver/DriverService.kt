package com.bruna.guedes.fleet_control.business.driver

import com.bruna.guedes.fleet_control.api.routes.RouteListResponse
import java.util.*

interface DriverService {

    fun saveDriver(driverDTO: NewDriverDTO): DriverDTO

    fun exists(driverId: UUID): Boolean

    fun getAvailableRoutes(): RouteListResponse
}