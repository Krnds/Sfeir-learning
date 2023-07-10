package com.karinedias.recipesapp;

import com.karinedias.recipesapp.model.Recipe;
import com.karinedias.recipesapp.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RecipesAppApplicationTests {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void recipeThatHasId_exists() throws Exception {
        Optional<Recipe> recipesFound = recipeRepository.findByIdRecipe(662375);
        assertEquals(662375, recipesFound.get().getIdRecipe());
    }

    @Test
    public void findAll_shouldReturnAllData() throws Exception {
        List<Recipe> recipesFound = recipeRepository.findAll();
        assertEquals(recipesFound.size(), 13);
    }

    @Test
    public void findMostLikedRecipe_shouldReturnExpected() throws Exception {
        Recipe mostLikedRecipe = recipeRepository.findTopByOrderByLikesDesc();
        assertEquals(mostLikedRecipe.getLikes(), 19);
    }

}
