package com.bruna.guedes.fleet_control.data.truck

import com.bruna.guedes.fleet_control.business.truck.Truck
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TruckRepository : MongoRepository<Truck, UUID>, CustomTruckRepository