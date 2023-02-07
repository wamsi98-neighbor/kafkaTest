package com.example.kafkatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static  final String TOPIC = "kafka-demo";
    private final KafkaTemplate<String, String> kafkaTemplate;  // 생성자 주입 (생성자 기반의 DI),  https://eboong.tistory.com/525

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        System.out.println(String.format("Produce message : %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }

    /*
        KafkaProducer는 위와 같다. TOPIC은 propertiese에서 설정한 TOPIC값과 동일하게 설정해줘야 함.
        핵심은 producer는 this.kafkaTemplate.send(TOPIC, message);을 통해서 TOPIC에 해당하는 message를 전달하는 것.
     */
}
