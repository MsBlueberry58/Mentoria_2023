package com.bruna.guedes.fleet_control.business.driver

import java.util.*

data class NewDriverDTO(
    val name: String,
    val cnhType: String,
    val cpf: String
)

data class DriverDTO(
    val id: UUID,
    val name: String,
    val cnhType: String,
    val cpf: String
)

fun NewDriverDTO.toDriver() = Driver(UUID.randomUUID(), this.name, this.cnhType, this.cpf)

fun Driver.toDTO() = DriverDTO(this.id, this.name, this.cnhType, this.cpf)