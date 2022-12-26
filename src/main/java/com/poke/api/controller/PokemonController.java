package com.poke.api.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.poke.api.model.Pokemon;
import com.poke.api.service.PokeApiService;

@Controller
public class PokemonController {

    PokeApiService pokeApiService;

    public PokemonController(PokeApiService pokeApiService) {
        this.pokeApiService = pokeApiService;
    }

    @PostMapping("/pokemon")
    public String postPokemonPage(Model model, String input) {
        Optional<Pokemon> result = pokeApiService.get(input.toLowerCase());
        if (result.isPresent()) {
            Pokemon pokemon = result.get();
            model.addAttribute("name", pokemon.getName());
            model.addAttribute("imageUrl", pokemon.getImageUrl());
            model.addAttribute("move", pokemon.getMove());
        } else {
            model.addAttribute("error", "Pokemon " + input + " not found");
        }
        return "pokemon";
    }

    @GetMapping("/pokemon/{name}")
    public String getPokemonPage(Model model, @PathVariable String name) {
        Optional<Pokemon> result = pokeApiService.get(name);
        if (result.isPresent()) {
            Pokemon pokemon = result.get();
            model.addAttribute("name", pokemon.getName());
            model.addAttribute("imageUrl", pokemon.getImageUrl());
            model.addAttribute("move", pokemon.getMove());
        } else {
            model.addAttribute("error", "Pokemon " + name + " not found");
        }
        return "pokemon";
    }

}