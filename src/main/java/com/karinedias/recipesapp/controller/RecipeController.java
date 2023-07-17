package com.karinedias.recipesapp.controller;


import com.karinedias.recipesapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    private final RecipeRepository recipeRepository;

    @Autowired
    RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipes")
    String getAllRecipes() {
        return recipeRepository.findAll().toString();
    }

}
