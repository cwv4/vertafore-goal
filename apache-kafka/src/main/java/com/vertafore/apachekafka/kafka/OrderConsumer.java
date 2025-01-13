package com.vertafore.apachekafka.kafka;

import com.vertafore.apachekafka.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "orderTopic", groupId = "orderGroup", containerFactory = "orderKafkaListenerContainerFactory")
    public void consume(Order order) {
        LOGGER.info("Message received: {}", order);
        order.verify();
    }
}
