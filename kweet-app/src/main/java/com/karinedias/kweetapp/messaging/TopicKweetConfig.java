package com.karinedias.kweetapp.messaging;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicKweetConfig {

    private final String KWEET_TOPIC = "topic-kweet";

    @Bean
    public NewTopic createTweetTopic() {
        return TopicBuilder.name(KWEET_TOPIC)
                .partitions(1)
                .replicas(1)
                .compact()
                .build();
    }
}
