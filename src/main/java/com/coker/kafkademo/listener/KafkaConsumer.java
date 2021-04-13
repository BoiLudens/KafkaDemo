package com.coker.kafkademo.listener;

import com.coker.kafkademo.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "quickstart-events", groupId = "group_id")
    public void consume(String message) {
        System.out.println(
                "Consumed message: " + message
        );
    }

    @KafkaListener(topics = "user-events", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}
