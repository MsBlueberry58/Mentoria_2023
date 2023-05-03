package com.bruna.guedes.fleet_control.api.truck

import com.bruna.guedes.fleet_control.business.truck.LatLong
import com.bruna.guedes.fleet_control.business.truck.NewTruckDTO
import com.bruna.guedes.fleet_control.business.truck.TruckDTO
import com.bruna.guedes.fleet_control.business.truck.TruckService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/truck")
class TruckController(private val truckService: TruckService) {

    @PostMapping
    fun saveTruck(@RequestBody truckDTO: NewTruckDTO): ResponseEntity<TruckDTO> {
        val savedTruck = truckService.saveTruck(truckDTO)
        return ResponseEntity.status(201).body(savedTruck)
    }

    @GetMapping("/{truckId}")
    fun getTruck(@PathVariable("truckId") truckId: UUID): ResponseEntity<TruckDTO> {
        val retrievedTruck = truckService.getTruck(truckId)
        return ResponseEntity.status(200).body(retrievedTruck)
    }

    @PostMapping("/{truckId}/location")
    fun sendLocation(@PathVariable("truckId") truckId: UUID,
                     @RequestParam("lat") latitude: Float,
                     @RequestParam("long") longitude: Float) {
        val location = LatLong(latitude, longitude)
        truckService.saveLocation(truckId, location)
    }
}