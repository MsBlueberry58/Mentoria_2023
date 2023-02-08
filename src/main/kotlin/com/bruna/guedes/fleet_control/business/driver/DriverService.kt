package com.bruna.guedes.fleet_control.business.driver

interface DriverService {

    fun saveDriver(driverDTO: NewDriverDTO): DriverDTO
}