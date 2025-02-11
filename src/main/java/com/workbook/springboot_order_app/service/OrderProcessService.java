package com.workbook.springboot_order_app.service;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class OrderProcessService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    ProcessEngine processEngine;

    @Autowired
    TaskService taskService;

    public OrderProcessService(KafkaTemplate<String, String> kafkaTemplate, RuntimeService runtimeService) {
        this.kafkaTemplate = kafkaTemplate;
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    public void placeOrder(Long orderId) {
        runtimeService.startProcessInstanceByKey("orderProcess", Collections.singletonMap("orderId", orderId));
    }

    public void processPayment(Long orderId) {
        kafkaTemplate.send("payment-events", "Payment Processed for Order ID: " + orderId);
    }

    public void completeUserTask(String orderId) {
        Task task = processEngine.getTaskService().createTaskQuery().list().get(0);
        taskService.complete(task.getId());
    }

}
