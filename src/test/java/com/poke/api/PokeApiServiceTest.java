package com.poke.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.poke.api.model.Pokemon;
import com.poke.api.service.PokeApiService;

public class PokeApiServiceTest {
    @Test
    public void shouldGetName() {
        PokeApiService pokeApiService = new PokeApiService();
        Optional<Pokemon> pokemon = pokeApiService.get("pikachu");
        assertTrue(pokemon.isPresent());
        Pokemon actual = pokemon.get();
        assertEquals("Pikachu", actual.getName());
    }

    @Test
    public void shouldGetImageUrl() {
        PokeApiService pokeApiService = new PokeApiService();
        Optional<Pokemon> pokemon = pokeApiService.get("pikachu");
        assertTrue(pokemon.isPresent());
        Pokemon expected = pokemon.get();
        String expectUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png";
        assertEquals(expectUrl, expected.getImageUrl());
    }

    @Test
    public void shouldGetMoves() {
        PokeApiService pokeApiService = new PokeApiService();
        Optional<Pokemon> pokemon = pokeApiService.get("pikachu");
        assertTrue(pokemon.isPresent());
        Pokemon expected = pokemon.get();
        assertEquals(96, expected.getMove().size());
        List<String> moves = expected.getMove();
        assertThat(moves).contains("pay-day", "mega-punch", "thunder-punch");
    }

    @Test
    public void shouldReturnNull() {
        PokeApiService pokeApiService = new PokeApiService();
        Optional<Pokemon> pokemon = pokeApiService.get("127UnKnow");
        assertFalse(pokemon.isPresent());
    }
}
