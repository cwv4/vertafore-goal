package com.vertafore.apachekafka.controller;

import com.vertafore.apachekafka.kafka.UserProducer;
import com.vertafore.apachekafka.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserProducer userProducer;

    public UserController(UserProducer kafkaProducer) {
        this.userProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        userProducer.sendMessage(user);
        return ResponseEntity.ok(String.format("Json message to be sent to the topic: %s", user));
    }
}
