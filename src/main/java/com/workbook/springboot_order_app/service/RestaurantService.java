package com.workbook.springboot_order_app.service;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public RestaurantService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void processDelivery(Long orderId) {
        kafkaTemplate.send("delivery-events", "Proceed with delivery for order ID: " + orderId);
    }
}
