package com.bruna.guedes.fleet_control.business.truck

import org.springframework.data.annotation.Id
import java.util.*

data class Truck(
    @Id val id: UUID,
    val driver: UUID,
    val model: String,
    val loadCapacity: Int,
    val status: String,
    val location: LatLong? = null
)
