package Jogo_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class PokemonEstagio2 extends Pokemon {
    
    public static ArrayList<String> PokemonsEstagio2 = new ArrayList<>(Arrays.asList("Venusaur", "Charizard", "Blastoise", "Butterfree", "Beedrill",
    "Pidgeot", null, null, null, "Raichu", null, "Nidoqueen", "Nidoking", null, null, null, null, "Vileplume", null, null, null, null, null, null, null,
    "Poliwrath", "Alakazam", "Machamp", "Victreebel", null, "Golem", null, null, null, null, null, null, null, null, "Gengar", null, null, null, null,
    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
    null, null, null, null, null, null,  "Dragonite", null, null));

    public void evoluir(){
        
    }    
    
    PokemonEstagio2(String nome, Treinador iniciante){
        this.nome = nome;
        estagio = 2;
        level = getRandomLevel();
        iniciante.Pokemons_Capturados.add(this);
    }

}
