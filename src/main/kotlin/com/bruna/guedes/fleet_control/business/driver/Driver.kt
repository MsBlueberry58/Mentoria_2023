package com.bruna.guedes.fleet_control.business.driver

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Driver(
    @Id val id: UUID,
    val name: String,
    val cnhType: String,
    @Indexed(unique = true) val cpf: String
)