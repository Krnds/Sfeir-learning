package com.karinedias.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Field("id")
    private long id;
    private double amount;
    private String unit;
    private String aisle;
    private String name;
    private String originalName;
    private String[] meta;
}
