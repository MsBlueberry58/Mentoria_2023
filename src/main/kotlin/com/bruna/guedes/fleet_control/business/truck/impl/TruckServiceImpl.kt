package com.bruna.guedes.fleet_control.business.truck.impl

import com.bruna.guedes.fleet_control.business.driver.DriverService
import com.bruna.guedes.fleet_control.business.truck.*
import com.bruna.guedes.fleet_control.data.truck.TruckRepository
import com.bruna.guedes.fleet_control.exception.DriverDoesNotExistException
import org.springframework.stereotype.Service
import java.util.*

@Service
class TruckServiceImpl(private val truckRepository: TruckRepository, private val driverService: DriverService) :
    TruckService {

    override fun saveTruck(truckDTO: NewTruckDTO): TruckDTO {
        if(driverService.exists(truckDTO.driver)) {
            return truckRepository.save(truckDTO.toTruck()).toDto()
        }
        throw DriverDoesNotExistException("Driver does not exist")
    }

    override fun getTruck(truckId: UUID): TruckDTO {
        return truckRepository.findById(truckId).get().toDto()
    }

    override fun saveLocation(truckId: UUID, latLong: LatLong) {
        truckRepository.updateLocation(truckId, latLong)
    }
}