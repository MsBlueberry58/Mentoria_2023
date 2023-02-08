package com.bruna.guedes.fleet_control.api.driver

import com.bruna.guedes.fleet_control.business.driver.DriverDTO
import com.bruna.guedes.fleet_control.business.driver.DriverService
import com.bruna.guedes.fleet_control.business.driver.NewDriverDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/driver")
class DriverController(
    val driverService: DriverService
) {

    @PostMapping
    fun createDriver(@RequestBody driverDTO: NewDriverDTO): ResponseEntity<DriverDTO> {
        val driver = driverService.saveDriver(driverDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(driver)
    }
}