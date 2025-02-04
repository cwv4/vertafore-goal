package com.vertafore.apachekafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StringConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringConsumer.class);

    @KafkaListener(topics = "stringTopic", groupId = "stringGroup", containerFactory = "stringKafkaListenerContainerFactory")
    public void consume(String message) {
        LOGGER.info("Message received: {}", message);
    }
}
