package com.fastus.spring5recipeapp.repositories;

import com.fastus.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Tom - 14.01.2021
 */
public interface RecipeRepository extends CrudRepository<Recipe,Long> {

}
