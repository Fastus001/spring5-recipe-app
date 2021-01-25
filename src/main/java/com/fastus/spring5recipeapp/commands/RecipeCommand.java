package com.fastus.spring5recipeapp.commands;

import com.fastus.spring5recipeapp.domain.Category;
import com.fastus.spring5recipeapp.domain.Difficulty;
import com.fastus.spring5recipeapp.domain.Ingredient;
import com.fastus.spring5recipeapp.domain.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tom - 25.01.2021
 */
@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private Notes notes;
    private Set<Category> categories = new HashSet<>();
}
