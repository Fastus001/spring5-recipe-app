package com.fastus.spring5recipeapp.services;

import com.fastus.spring5recipeapp.commands.IngredientCommand;
import com.fastus.spring5recipeapp.converters.IngredientCommandToIngredient;
import com.fastus.spring5recipeapp.converters.IngredientToIngredientCommand;
import com.fastus.spring5recipeapp.domain.Ingredient;
import com.fastus.spring5recipeapp.domain.Recipe;
import com.fastus.spring5recipeapp.repositories.RecipeRepository;
import com.fastus.spring5recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Tom - 31.01.2021
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;


    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient,
                                 RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(recipeOptional.isEmpty()){
            //todo impl error handling
            log.error("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientToIngredientCommand::convert)
                .findFirst();

        if(ingredientCommandOptional.isEmpty()){
            //todo impl error handling
            log.error("Ingredient id not found. Id: " + ingredientId);
        }
        return ingredientCommandOptional.get();
    }

    @Override
    @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());

        if(recipeOptional.isEmpty()){
            //todo toss error if not found!

            log.error("Recipe not found for id:" + command.getRecipeId());
            return new IngredientCommand();
        }else{
            Recipe recipe  = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe.getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if(ingredientOptional.isPresent()){
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUom(unitOfMeasureRepository
                .findById(command.getUom().getId())
                .orElseThrow(()->new RuntimeException("UOM NOT FOUND"))); //todo address this
            }else{
                //add new ingredient
                recipe.addIngredient(ingredientCommandToIngredient.convert(command));
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            //todo check for fail
            return ingredientToIngredientCommand.convert(savedRecipe.getIngredients().stream()
            .filter(ingredient -> ingredient.getId().equals(command.getId()))
            .findFirst()
            .get());
        }
    }
}
