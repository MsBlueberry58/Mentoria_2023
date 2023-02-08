package com.bruna.guedes.fleet_control.business.driver.impl

import com.bruna.guedes.fleet_control.business.driver.*
import com.bruna.guedes.fleet_control.data.driver.DriverRepository
import org.springframework.stereotype.Service

@Service
class DriverServiceImpl(
    val driverRepository: DriverRepository
) : DriverService {

    override fun saveDriver(driverDTO: NewDriverDTO): DriverDTO {
        val savedDriver = driverRepository.save(driverDTO.toDriver())
        return savedDriver.toDTO()
    }
}