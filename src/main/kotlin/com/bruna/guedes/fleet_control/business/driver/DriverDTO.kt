package com.bruna.guedes.fleet_control.business.driver

import java.util.*

data class NewDriverDTO(
    val name: String,
    val cnhType: String
)

data class DriverDTO(
    val id: UUID,
    val name: String,
    val cnhType: String
)

fun NewDriverDTO.toDriver() = Driver(UUID.randomUUID(), this.name, this.cnhType)

fun Driver.toDTO() = DriverDTO(this.id, this.name, this.cnhType)