package com.vertafore.apachekafka.controller;

import com.vertafore.apachekafka.kafka.OrderProducer;
import com.vertafore.apachekafka.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderProducer kafkaProducer;

    public OrderController(OrderProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Order order) {
        kafkaProducer.sendMessage(order);
        return ResponseEntity.ok(String.format("Json message to be sent to the topic: %s", order));
    }
}
