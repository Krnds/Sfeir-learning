package com.karinedias.kweetapp.service;

import com.karinedias.kweetapp.model.Kweet;
import com.karinedias.kweetapp.repository.KweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KweetService {

    //TODO: from kafka message received, send it to controller to display them in frontend

    private KweetRepository kweetRepository;


    public KweetService(KweetRepository kweetRepository) {
        this.kweetRepository = kweetRepository;
    }

    public List<Kweet> getLastKweets() {
        return kweetRepository.findFirst2ByOrderByTimestampDesc();
    }


    public void saveKweet(Kweet Kweet) {
        kweetRepository.save(Kweet);
    }
}