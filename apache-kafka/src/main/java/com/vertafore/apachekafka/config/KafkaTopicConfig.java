package com.vertafore.apachekafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic stringTopic() {
        return TopicBuilder.name("stringTopic")
                .build();
    }

    @Bean
    public NewTopic userTopic() {
        return TopicBuilder.name("userTopic")
                .build();
    }

    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name("orderTopic")
                .build();
    }
}
