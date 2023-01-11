package com.bruna.guedes.fleet_control.business.truck

import java.util.UUID

data class Truck(
    val id: UUID,
    val driver: UUID,
    val model: String,
    val loadCapacity: Int,
    val status: String
)
