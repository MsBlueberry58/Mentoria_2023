package com.bruna.guedes.fleet_control.business.truck.impl

import com.bruna.guedes.fleet_control.business.truck.*
import com.bruna.guedes.fleet_control.data.truck.TruckRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TruckServiceImpl(private val truckRepository: TruckRepository) : TruckService {

    override fun saveTruck(truckDTO: NewTruckDTO): TruckDTO {
        return truckRepository.save(truckDTO.toTruck()).toDto()
    }

    override fun getTruck(truckId: UUID): TruckDTO {
        return truckRepository.findById(truckId).get().toDto()
    }
}