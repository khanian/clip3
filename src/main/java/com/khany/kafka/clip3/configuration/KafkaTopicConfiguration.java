package com.khany.kafka.clip3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public KafkaAdmin.NewTopics clip3s() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("clip3").build()
        );
    }
}
