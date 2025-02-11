package com.workbook.springboot_order_app.controller;

import com.workbook.springboot_order_app.service.OrderProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderProcessService orderService;


    @GetMapping("/place/{orderId}")
    public String placeOrder(@PathVariable Long orderId) {
        orderService.placeOrder(orderId);
        return "Order Placed.";
    }

    @GetMapping("/tasks/proceedToPayment/{orderId}")
    public String completeTask(@PathVariable String orderId) {
        orderService.completeUserTask(orderId);
        return "Order Completed!";
    }

}