package com.bruna.guedes.fleet_control.business.exception

class DriverDoesNotExistException(override val message: String) : RuntimeException(message)

class DriverAlreadyExistsException(override val message: String) : RuntimeException(message)