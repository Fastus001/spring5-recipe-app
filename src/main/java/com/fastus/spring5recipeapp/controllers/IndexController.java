package com.fastus.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tom - 21.12.2020
 */
@Controller
public class IndexController {


    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        System.out.println("Some message...23gdfgdgf333asdadad");
        return "index";
    }
}
