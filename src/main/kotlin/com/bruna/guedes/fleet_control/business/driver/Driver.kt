package com.bruna.guedes.fleet_control.business.driver

import java.util.UUID

data class Driver(
    val id: UUID,
    val name: String,
    val cnhType: String
)