package com.karinedias.kweetapp.controller;

import com.karinedias.kweetapp.messaging.KweetProducer;
import com.karinedias.kweetapp.model.Kweet;
import com.karinedias.kweetapp.service.KweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class KweetController {

    private static final Logger logger = LoggerFactory.getLogger(KweetController.class);

    private final KweetService kweetService;
    private final KweetProducer kweetProducer;


    public KweetController(KweetService kweetService, KweetProducer kweetProducer) {
        this.kweetService = kweetService;
        this.kweetProducer = kweetProducer;
    }

    @PostMapping("/sendKweet")
    public void saveAndPublishKweet(@RequestBody Kweet kweet) {
        logger.info("[Kweet was received from {} : {} on time {}]", kweet.getUsername(), kweet.getMessage(), kweet.getTimestamp());
        kweetService.saveKweet(kweet);
        kweetProducer.publishKweet(kweet);
    }

    @GetMapping("/lastKweets")
    public List<Kweet> getLastTweet() {
        List<Kweet> kweets = kweetService.getLastKweets();
        System.out.println("[Last kweets are " + kweets + "]");
        return kweets;
    }

    @GetMapping(value = "/username")
    public void getUsername(@RequestParam String username) {
        System.out.println("[username is " + username + "]");
    }

//    @PostMapping("/saveKweet")
//    public void saveKweet(@RequestBody Kweet kweet) {
//        logger.info("Kweet was received from {} : {}", kweet.getUsername(), kweet.getMessage());
//        kweetService.saveKweet(kweet);
//        //infosProducer.publishTweet(tweet.getUsername(), tweet.getMessage());
//    }
}
