package br.com.itau.producer.utils


import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

class ConfiguracaoJson {

    var jacksonMapper = jacksonObjectMapper().registerKotlinModule().setPropertyNamingStrategy(
        PropertyNamingStrategy.SNAKE_CASE
    )
}