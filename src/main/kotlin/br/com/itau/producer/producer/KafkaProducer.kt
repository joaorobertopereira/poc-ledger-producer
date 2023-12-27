package br.com.itau.producer.producer

import br.com.itau.producer.domain.kafka.JsonPayload
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducer(private val kafaTemplate: KafkaTemplate<String, JsonPayload>,
                    @Value("\${kafka.topic.name}") private val topic: String) {
    companion object {
        val log: Logger = LoggerFactory.getLogger(KafkaProducer::class.java)
    }
    fun sendMessage(jsonPayload: JsonPayload) {
        val producerRecord = ProducerRecord(topic, jsonPayload.data.identificadorTransacional, jsonPayload)
        kafaTemplate.send(producerRecord)
        log.info("Mensagem enviada.")
    }
}