package com.fastus.spring5recipeapp.services;

import com.fastus.spring5recipeapp.commands.RecipeCommand;
import com.fastus.spring5recipeapp.domain.Recipe;

import java.util.Set;

/**
 * Created by Tom - 17.01.2021
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long id);
}
