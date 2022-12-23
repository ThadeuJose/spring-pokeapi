package com.poke.api.model;

import java.util.List;

import org.springframework.util.StringUtils;

public class Pokemon {
    private String name;
    private String imageUrl;
    private List<String> move;

    public Pokemon(String name, String imageUrl, List<String> move) {
        this.name = StringUtils.capitalize(name);
        this.imageUrl = imageUrl;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getMove() {
        return move;
    }

}
