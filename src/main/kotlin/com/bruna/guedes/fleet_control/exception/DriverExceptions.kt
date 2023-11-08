package com.bruna.guedes.fleet_control.exception

class DriverDoesNotExistException(override val message: String) : RuntimeException(message)

class DriverAlreadyExistsException(override val message: String) : RuntimeException(message)