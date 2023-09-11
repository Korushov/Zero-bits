package ru.korushov.zero.consumer;


import org.apache.kafka.clients.KafkaClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Vitaly Korushov
 */

public class ZeroCounter {
    KafkaClient kafkaClient;

    @Autowired
    public ZeroCounter(KafkaClient kafkaClient) {
        this.kafkaClient = kafkaClient;
    }


}
