package com.fastus.spring5recipeapp.services;

import com.fastus.spring5recipeapp.commands.IngredientCommand;

/**
 * Created by Tom - 31.01.2021
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
