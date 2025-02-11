package com.workbook.springboot_order_app.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    @KafkaListener(topics = "payment-events", groupId = "order-group")
    public void listen(String message) {
        System.out.println("Payment Event Received: " + message);
    }
}