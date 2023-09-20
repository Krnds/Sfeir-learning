package com.karinedias.kweetapp.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document(collection = "kweets")
@Data
public class Kweet {

    @Id
    String id;

    Long timestamp;

    private String username;

    private String message;

    public Kweet(Long timestamp, String username, String message) {
        this.timestamp = timestamp;
        this.username = username;
        this.message = message;
    }
}
