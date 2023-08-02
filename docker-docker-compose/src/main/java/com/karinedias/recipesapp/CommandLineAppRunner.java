package com.karinedias.recipesapp;

import com.karinedias.recipesapp.model.Recipe;
import com.karinedias.recipesapp.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CommandLineAppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppRunner.class);

    private final RecipeService recipeService;

    @Autowired
    public CommandLineAppRunner(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("One moment please, fetching recipes from database... \uD83D\uDC69\u200D\uD83C\uDF73");
        List<Recipe> recipes = recipeService.getAllRecipes();
        recipes.forEach(System.out::println);
    }
}