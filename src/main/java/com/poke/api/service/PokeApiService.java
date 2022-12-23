package com.poke.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.poke.api.model.Pokemon;

import kong.unirest.Unirest;

@Service
public class PokeApiService {

    private JsonProvider jsonProvider;

    public PokeApiService() {
        Unirest.config().defaultBaseUrl("https://pokeapi.co/api/v2/pokemon/");
        jsonProvider = Configuration.defaultConfiguration().jsonProvider();
    }

    public Optional<Pokemon> get(String name) {
        String json = Unirest.get("/{name}").routeParam("name", name).asString().getBody();
        Object document = jsonProvider.parse(json);

        String pokemonName = JsonPath.read(document, "$.name");
        String imageUrl = JsonPath.read(document, "$.sprites.other.official-artwork.front_default");
        List<String> moves = JsonPath.read(document, "$.moves[*].move.name");

        Pokemon pokemon = new Pokemon(pokemonName, imageUrl, moves);
        return Optional.ofNullable(pokemon);
    }

}
