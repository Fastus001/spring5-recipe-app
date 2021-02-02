package com.fastus.spring5recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Tom - 02.02.2021
 */
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}
