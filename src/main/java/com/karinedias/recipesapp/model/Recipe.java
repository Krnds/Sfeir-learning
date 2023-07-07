package com.karinedias.recipesapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("test")
public class Recipe {

    @Id
    private BigInteger id;
    @Field("id")
    private long idRecipe;
    private String title;
    private int usedIngredientCount;
    private int missedIngredientCount;
    private Ingredient[] missedIngredients;
    private Ingredient[] usedIngredients;
    private int likes;
}
