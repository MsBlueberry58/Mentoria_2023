package com.bruna.guedes.fleet_control.business.driver.impl

import com.bruna.guedes.fleet_control.api.routes.RouteListResponse
import com.bruna.guedes.fleet_control.business.driver.*
import com.bruna.guedes.fleet_control.data.driver.DriverRepository
import com.bruna.guedes.fleet_control.third_party.RouteApiClient
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DriverServiceImpl(
    val driverRepository: DriverRepository,
    val apiClient: RouteApiClient
) : DriverService {

    override fun saveDriver(driverDTO: NewDriverDTO): DriverDTO {
        val savedDriver = driverRepository.save(driverDTO.toDriver())
        return savedDriver.toDTO()
    }

    override fun exists(driverId: UUID) = driverRepository.existsById(driverId)

    override fun getAvailableRoutes(): RouteListResponse {
        return apiClient.routes()
    }
}