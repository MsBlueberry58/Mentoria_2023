package com.bruna.guedes.fleet_control.business.driver

import org.springframework.data.annotation.Id
import java.util.*

data class Driver(
    @Id val id: UUID,
    val name: String,
    val cnhType: String
)