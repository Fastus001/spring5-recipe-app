package com.fastus.spring5recipeapp.converters;

import com.fastus.spring5recipeapp.commands.RecipeCommand;
import com.fastus.spring5recipeapp.domain.Recipe;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Tom - 25.01.2021
 */
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {




    @Override
    public Recipe convert(RecipeCommand source) {
        return null;
    }
}
