package com.fastus.spring5recipeapp.converters;

import com.fastus.spring5recipeapp.commands.NotesCommand;
import com.fastus.spring5recipeapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {

    public static final String RECIPE_NOTES = "Notes";
    public static final Long ID_VALUE = 1L;

    NotesToNotesCommand converter;

    @BeforeEach
    void setUp() {
        converter = new NotesToNotesCommand();
    }

    @Test
    void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    void convert() {
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        NotesCommand command = converter.convert(notes);

        assertNotNull(command);
        assertAll(
                () -> assertEquals(ID_VALUE, command.getId()),
                () -> assertEquals(RECIPE_NOTES, command.getRecipeNotes()));

    }
}