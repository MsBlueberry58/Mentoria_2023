package com.bruna.guedes.fleet_control.infrastructure.data.truck

import com.bruna.guedes.fleet_control.business.truck.LatLong
import java.util.UUID


fun interface CustomTruckRepository {

    fun updateLocation(truckId: UUID, location: LatLong)
}