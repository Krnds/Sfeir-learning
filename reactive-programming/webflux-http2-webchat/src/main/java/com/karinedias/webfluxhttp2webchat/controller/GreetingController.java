package com.karinedias.webfluxhttp2webchat.controller;

import com.karinedias.webfluxhttp2webchat.model.Greeting;
import com.karinedias.webfluxhttp2webchat.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        return new Greeting("Hello " + message.getName() + "!\n How are you today?");
    }

}
