package com.bruna.guedes.fleet_control.data.truck

import com.bruna.guedes.fleet_control.business.truck.LatLong
import java.util.UUID


interface CustomTruckRepository {

    fun updateLocation(truckId: UUID, location: LatLong)
}