package com.sampleapp.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @GetMapping("health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "order-service");
    }
}
