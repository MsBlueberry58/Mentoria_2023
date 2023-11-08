package com.bruna.guedes.fleet_control.infrastructure.data.driver

import com.bruna.guedes.fleet_control.business.driver.Driver
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DriverRepository : MongoRepository<Driver, UUID> {

}