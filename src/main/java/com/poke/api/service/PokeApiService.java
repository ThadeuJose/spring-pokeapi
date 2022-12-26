package com.poke.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.poke.api.model.Pokemon;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@Service
public class PokeApiService {

    private JsonProvider jsonProvider;

    public PokeApiService() {
        Unirest.config().defaultBaseUrl("https://pokeapi.co/api/v2/pokemon/");
        jsonProvider = Configuration.defaultConfiguration().jsonProvider();
    }

    public Optional<Pokemon> get(String name) {
        Pokemon pokemon = null;
        HttpResponse<String> request = Unirest.get("/{name}").routeParam("name", name).asString();

        if (request.isSuccess()) {
            String json = request.getBody();
            Object document = jsonProvider.parse(json);

            String pokemonName = JsonPath.read(document, "$.name");
            String imageUrl = JsonPath.read(document, "$.sprites.other.official-artwork.front_default");
            List<String> moves = JsonPath.read(document, "$.moves[*].move.name");

            pokemon = new Pokemon(pokemonName, imageUrl, moves);
        }

        return Optional.ofNullable(pokemon);
    }

}
