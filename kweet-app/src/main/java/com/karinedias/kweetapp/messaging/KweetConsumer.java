//package com.karinedias.kweetapp.messaging;
//
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.karinedias.kweetapp.model.Kweet;
//import com.karinedias.kweetapp.service.KweetService;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.protocol.Message;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Logger;
//
//import static java.util.logging.Logger.getLogger;
//
//
//@EnableKafka
//@Configuration
//public class KweetConsumer {
//
//    private static final Logger logger = getLogger(KweetConsumer.class.getPackage().getName());
//    private KweetService kweetService;
//
//    public KweetConsumer(KweetService kweetService) {
//        this.kweetService = kweetService;
//    }
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(
//                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                bootstrapAddress);
//        props.put(
//                ConsumerConfig.GROUP_ID_CONFIG,
//                groupId);
//        props.put(
//                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//                StringDeserializer.class);
//        props.put(
//                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//                StringDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(props);
//    }
//
//
//    @Bean
//    public Map<String, Object> consumerConfigurations() {
//        Map<String, Object> configurations = new HashMap<>();
//        configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configurations.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
//        configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        configurations.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        return configurations;
//    }
//
//
//
//
//}
