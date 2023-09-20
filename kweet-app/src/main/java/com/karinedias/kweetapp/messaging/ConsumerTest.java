package com.karinedias.kweetapp.messaging;

import com.karinedias.kweetapp.model.Kweet;
import com.karinedias.kweetapp.service.KweetService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class ConsumerTest {
    private KweetService tweetService;

    public ConsumerTest(KweetService tweetService) {
        this.tweetService = tweetService;
    }

    private static final Logger logger = getLogger(ConsumerTest.class.getPackage().getName());

    @KafkaListener(id = "myId", topics = "topic-kweet") //topic-kweet
    public void listenTweetsFromApp1(@Payload String in,
                                     @Header(KafkaHeaders.RECEIVED_KEY) String username,
                                     @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String timestamp //The header for holding the timestamp of the consumer record.

    ) {
        logger.info("Listening to kweets from topic-kweets");
        System.out.println("Timestamp = " + timestamp +  " I've received from " + username);
        //TODO: create builder
        tweetService.saveKweet(new Kweet(Long.getLong(timestamp), username, in));
    }

}
