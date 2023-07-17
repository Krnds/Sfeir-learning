package com.karinedias.recipesapp.repository;

import com.karinedias.recipesapp.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findAll();

    @Override
    <S extends Recipe> List<S> saveAll(Iterable<S> entities);

    Optional<Recipe> findByIdRecipe(long id);

    Recipe findTopByOrderByLikesDesc();

}


