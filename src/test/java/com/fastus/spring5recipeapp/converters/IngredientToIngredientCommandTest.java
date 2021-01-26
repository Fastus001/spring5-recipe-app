package com.fastus.spring5recipeapp.converters;

import com.fastus.spring5recipeapp.commands.IngredientCommand;
import com.fastus.spring5recipeapp.domain.Ingredient;
import com.fastus.spring5recipeapp.domain.Recipe;
import com.fastus.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal(1);
    public static final String DESCRIPTION =   "Cheeseburger";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    IngredientToIngredientCommand converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    void convert() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setRecipe(RECIPE);
        ingredient.setDescription(DESCRIPTION);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(unitOfMeasure);

        IngredientCommand ingredientCommand = converter.convert(ingredient);

        assertNotNull(ingredientCommand);
        assertNotNull(ingredientCommand.getUnitOfMeasure());
        assertAll(
                () -> assertEquals(ID_VALUE, ingredientCommand.getId()),
                () -> assertEquals(AMOUNT, ingredientCommand.getAmount()),
                () -> assertEquals(DESCRIPTION, ingredientCommand.getDescription()),
                () -> assertEquals(UOM_ID, ingredientCommand.getUnitOfMeasure().getId())
        );
    }

    @Test
    void convertNullUom() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setRecipe(RECIPE);
        ingredient.setDescription(DESCRIPTION);

        ingredient.setUom(null);

        IngredientCommand ingredientCommand = converter.convert(ingredient);

        assertNotNull(ingredientCommand);
        assertNull(ingredientCommand.getUnitOfMeasure());
        assertAll(
                () -> assertEquals(ID_VALUE, ingredientCommand.getId()),
                () -> assertEquals(AMOUNT, ingredientCommand.getAmount()),
                () -> assertEquals(DESCRIPTION, ingredientCommand.getDescription())
        );
    }
}