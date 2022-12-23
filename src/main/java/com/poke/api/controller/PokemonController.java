package com.poke.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokemonController {

    @GetMapping("/pokemon")
    public String getPokemonPage(Model model) {
        model.addAttribute("name", "Pikachu");
        return "pokemon";
    }

}