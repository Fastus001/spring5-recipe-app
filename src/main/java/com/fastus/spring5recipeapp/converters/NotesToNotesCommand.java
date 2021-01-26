package com.fastus.spring5recipeapp.converters;

import com.fastus.spring5recipeapp.commands.NotesCommand;
import com.fastus.spring5recipeapp.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Tom - 26.01.2021
 */
@Component
public class NotesToNotesCommand  implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if(source==null){
            return null;
        }

        final NotesCommand command = new NotesCommand();
        command.setId(source.getId());
        command.setRecipeNotes(source.getRecipeNotes());
        return command;
    }
}
