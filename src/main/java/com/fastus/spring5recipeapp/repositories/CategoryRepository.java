package com.fastus.spring5recipeapp.repositories;

import com.fastus.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Tom - 14.01.2021
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
}
