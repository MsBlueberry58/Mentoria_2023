package com.bruna.guedes.fleet_control.api

import com.bruna.guedes.fleet_control.exception.DriverDoesNotExistException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody


@ControllerAdvice
class AppControllerAdvice{

    @ResponseBody
    @ExceptionHandler(DriverDoesNotExistException::class)
    fun driverDoesNotExistException(ex: DriverDoesNotExistException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDetail(ex.message))
    }

    data class ErrorDetail(val message: String)
}
