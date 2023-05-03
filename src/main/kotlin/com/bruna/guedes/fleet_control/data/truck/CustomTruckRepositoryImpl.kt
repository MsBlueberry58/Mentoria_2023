package com.bruna.guedes.fleet_control.data.truck

import com.bruna.guedes.fleet_control.business.truck.LatLong
import com.bruna.guedes.fleet_control.business.truck.Truck
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import java.util.*

class CustomTruckRepositoryImpl(private val mongoTemplate: MongoTemplate) : CustomTruckRepository {

    override fun updateLocation(truckId: UUID, location: LatLong) {
        val query = Query.query(Criteria.where("_id").`is`(truckId))
        mongoTemplate.updateFirst(query, Update.update("location", location), Truck::class.java)
    }
}