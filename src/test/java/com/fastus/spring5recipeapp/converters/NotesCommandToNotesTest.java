package com.fastus.spring5recipeapp.converters;

import com.fastus.spring5recipeapp.commands.NotesCommand;
import com.fastus.spring5recipeapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {

    public static final String RECIPE_NOTES = "Notes";
    public static final Long ID_VALUE = 1L;

    NotesCommandToNotes converter;

    @BeforeEach
    void setUp() {
        converter = new NotesCommandToNotes();
    }

    @Test
    void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    void convert() {
        NotesCommand command = new NotesCommand();
        command.setId(ID_VALUE);
        command.setRecipeNotes(RECIPE_NOTES);

        Notes notes = converter.convert(command);

        assertNotNull(notes);
        assertAll(
                () -> assertEquals(ID_VALUE, notes.getId()),
                () -> assertEquals(RECIPE_NOTES, notes.getRecipeNotes()));
    }
}