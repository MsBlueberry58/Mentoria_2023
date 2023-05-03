package com.bruna.guedes.fleet_control.business.truck

import java.util.UUID

interface TruckService {

    fun saveTruck(truckDTO: NewTruckDTO): TruckDTO

    fun getTruck(truckId: UUID): TruckDTO

    fun saveLocation(truckId: UUID, latLong: LatLong)
}