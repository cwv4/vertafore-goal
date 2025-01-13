package com.vertafore.apachekafka.kafka;

import com.vertafore.apachekafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumer.class);

    @KafkaListener(topics = "userTopic", groupId = "userGroup", containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user) {
        LOGGER.info("Message received: {}", user);
        user.verify();
    }
}
