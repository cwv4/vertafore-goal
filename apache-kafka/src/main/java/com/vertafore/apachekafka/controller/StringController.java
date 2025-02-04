package com.vertafore.apachekafka.controller;

import com.vertafore.apachekafka.kafka.StringProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/string")
public class StringController {

    private final StringProducer stringProducer;

    public StringController(StringProducer stringProducer) {
        this.stringProducer = stringProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        stringProducer.sendMessage(message);
        return ResponseEntity.ok(String.format("Message sent to the topic: %s", message));
    }
}
