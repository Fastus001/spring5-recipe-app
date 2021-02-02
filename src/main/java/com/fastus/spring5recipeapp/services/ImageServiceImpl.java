package com.fastus.spring5recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Tom - 02.02.2021
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService{

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("Received a file");
    }
}
