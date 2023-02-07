package com.example.kafkatest.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka-demo", groupId = "kafka-demo")
    public void consume(String message) throws IOException {
        System.out.println(String.format("Consumer message : %s", message));
    }
    /*
        KafkaConsumer는 위와 같다. topics와 groupid는 우선 properties에서 설정한 것으로 지정함
        핵심은 어노테이션 @KafkaListener(topics = "kafka-demo", groupId = "kafka-demo")
     */
}
