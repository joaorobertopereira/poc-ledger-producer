package br.com.itau.producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PocLedgerProducerApplication

fun main(args: Array<String>) {
    runApplication<PocLedgerProducerApplication>(*args)
}
