package com.fastus.spring5recipeapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tom - 14.01.2021
 */
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
