package com.bruna.guedes.fleet_control.business.driver.impl

import com.bruna.guedes.fleet_control.api.external.routes.RouteListResponse
import com.bruna.guedes.fleet_control.business.driver.*
import com.bruna.guedes.fleet_control.data.driver.DriverRepository
import com.bruna.guedes.fleet_control.exception.DriverAlreadyExistsException
import com.bruna.guedes.fleet_control.third_party.DecoratedRouteApiClient
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Service
import java.util.*

@Service
class DriverServiceImpl(
    val driverRepository: DriverRepository,
    val apiClient: DecoratedRouteApiClient
) : DriverService {

    override fun saveDriver(driverDTO: NewDriverDTO): DriverDTO {
        try {
            val savedDriver = driverRepository.save(driverDTO.toDriver())
            return savedDriver.toDTO()
        } catch (ex: DuplicateKeyException) {
            throw DriverAlreadyExistsException(ex.message!!)
        }
    }

    override fun exists(driverId: UUID) = driverRepository.existsById(driverId)

    override fun getAvailableRoutes(): RouteListResponse {
        return apiClient.routes()
    }
}