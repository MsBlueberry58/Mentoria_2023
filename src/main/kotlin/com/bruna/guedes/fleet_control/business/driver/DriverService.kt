package com.bruna.guedes.fleet_control.business.driver

import java.util.*

interface DriverService {

    fun saveDriver(driverDTO: NewDriverDTO): DriverDTO

    fun exists(driverId: UUID): Boolean
}