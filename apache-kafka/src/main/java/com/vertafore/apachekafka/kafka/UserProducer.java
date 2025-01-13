package com.vertafore.apachekafka.kafka;

import com.vertafore.apachekafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        LOGGER.info("Sending message: {}", user);

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "userTopic")
                .build();

        kafkaTemplate.send(message);
    }
}
