package com.karinedias.kweetapp.repository;

import com.karinedias.kweetapp.model.Kweet;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KweetRepository extends MongoRepository<Kweet, String> {

    List<Kweet> findByUsername(String username, Sort sort);


    //findFirst5ByOrderByPublicationDateDesc()
    List<Kweet> findFirst2ByOrderByTimestampDesc();
}
