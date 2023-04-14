package com.bruna.guedes.fleet_control.business.truck

import java.util.UUID

data class NewTruckDTO(
    val driver: UUID,
    val model: String,
    val loadCapacity: Int,
    val status: String
)

data class TruckDTO(
    val id: UUID,
    val driver: UUID,
    val model: String,
    val loadCapacity: Int,
    val status: String

    )

fun NewTruckDTO.toTruck() = Truck(UUID.randomUUID(), this.driver, this.model, this.loadCapacity, this.status)

fun Truck.toDto() = TruckDTO(this.id, this.driver, this.model, this.loadCapacity, this.status)