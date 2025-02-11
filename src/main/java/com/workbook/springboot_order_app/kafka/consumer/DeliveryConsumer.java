package com.workbook.springboot_order_app.kafka.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DeliveryConsumer {

    @KafkaListener(topics = "delivery-events", groupId = "order-group")
    public void listen(String message) {
        System.out.println("Delivery Event Received: " + message);
    }
}
