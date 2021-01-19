package com.fastus.spring5recipeapp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Tom - 14.01.2021
 */
@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    public Notes() {
    }

}
