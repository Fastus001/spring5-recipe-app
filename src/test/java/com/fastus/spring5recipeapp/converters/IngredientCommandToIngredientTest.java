package com.fastus.spring5recipeapp.converters;

import com.fastus.spring5recipeapp.commands.IngredientCommand;
import com.fastus.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.fastus.spring5recipeapp.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    public static final BigDecimal AMOUNT = new BigDecimal(1);
    public static final String DESCRIPTION =   "Cheeseburger";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    IngredientCommandToIngredient converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    void convert() {
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        command.setUom( unitOfMeasureCommand);

        Ingredient ingredient = converter.convert(command);

        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertAll(
                () -> assertEquals(ID_VALUE, ingredient.getId()),
                () -> assertEquals(AMOUNT, ingredient.getAmount()),
                () -> assertEquals(DESCRIPTION, ingredient.getDescription()),
                () -> assertEquals(UOM_ID, ingredient.getUom().getId())
        );
    }

    @Test
    void convertWithNullUom() {
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);

        Ingredient ingredient = converter.convert(command);

        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertAll(
                () -> assertEquals(ID_VALUE, ingredient.getId()),
                () -> assertEquals(AMOUNT, ingredient.getAmount()),
                () -> assertEquals(DESCRIPTION, ingredient.getDescription())
        );
    }
}