package com.bruna.guedes.fleet_control.config

import com.mongodb.MongoClientSettings
import org.bson.UuidRepresentation
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer
import org.springframework.stereotype.Component

@Component
class AppMongoCustomizer : MongoClientSettingsBuilderCustomizer {

    override fun customize(clientSettingsBuilder: MongoClientSettings.Builder) {
        clientSettingsBuilder.uuidRepresentation(UuidRepresentation.STANDARD)
    }
}