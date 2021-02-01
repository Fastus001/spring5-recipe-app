package com.fastus.spring5recipeapp.services;

import com.fastus.spring5recipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Created by Tom - 31.01.2021
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
