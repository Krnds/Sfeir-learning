package com.karinedias.kweetapp.messaging;

import com.karinedias.kweetapp.model.Kweet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KweetProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.tweet.name}")
    private String kweetTopic;


    public KweetProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void publishKweet(Kweet kweet) {
        Long timestamp = System.currentTimeMillis();
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate
                .send(kweetTopic, 0, kweet.getTimestamp(), kweet.getUsername(), kweet.getMessage());
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent Kweet from " + kweet.getUsername() + "=[" + kweet.getMessage() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        kweet.getMessage() + "] due to : " + ex.getMessage());
            }
        });
    }
}
